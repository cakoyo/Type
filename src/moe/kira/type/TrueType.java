package moe.kira.type;

import org.bukkit.Material;

@FunctionalInterface
public interface TrueType {
    boolean is(Material t);
}
