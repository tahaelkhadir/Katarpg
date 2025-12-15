package re.forestier.edu.rpg.character;

import java.util.HashMap;
import java.util.Map;


public class CharacterAttribute {
    private Map<String, Integer> attributes;

    public CharacterAttribute() {
        this.attributes = new HashMap<>();
    }

    
    public void addAttribute(String attributeName, int value) {
        attributes.put(attributeName, value);
    }

   
    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    
    public Integer getAttributeValue(String attributeName) {
        return attributes.getOrDefault(attributeName, 1);
    }
}
