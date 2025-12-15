Joueur ${player.characterName} joué par ${player.playerName}
Niveau : ${player.level} (XP totale : ${player.xp})

Capacités :
<#list player.attributes as name, value>
   ${name} : ${value}
</#list>

Inventaire :
<#list player.equipment as item>
   ${item.name}
</#list>
