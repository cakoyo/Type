package moe.kira.type;

import org.bukkit.plugin.java.JavaPlugin;

public class TypePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        for (Type type : Type.values())
            type.name();
        
    }
}
