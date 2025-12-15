package re.forestier.edu.rpg.game;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


public class PlayerDisplayService {

    private final Configuration cfg;

    public PlayerDisplayService() {
        cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(PlayerDisplayService.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

    public String displayPlayer(Player player) {
        try {
            Template template = cfg.getTemplate("player_display.ftl");

            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("player", new PlayerModel(player));

            StringWriter writer = new StringWriter();
            template.process(dataModel, writer);
            return writer.toString();

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            return "Erreur lors de l'affichage FreeMarker: " + e.getMessage();
        }
    }

    /**
     * Model class to expose player data to FreeMarker templates.
     */
    public static class PlayerModel {
        private final Player player;

        public PlayerModel(Player player) {
            this.player = player;
        }

        public String getPlayerName() {
            return player.getPlayerName();
        }

        public String getCharacterName() {
            return player.getCharacterName();
        }

        public int getLevel() {
            return player.getLevel();
        }

        public int getXp() {
            return player.getXp();
        }

        public Map<String, Integer> getAttributes() {
            return player.getAttributes();
        }

        public Object getEquipment() {
            return player.getEquipment();
        }
    }
}
