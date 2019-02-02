/** The MIT License (MIT)
 *
 * Copyright (c) 2018 Sotr
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 **/

package moe.kira.type;

import static org.bukkit.Material.*;

import java.lang.annotation.Documented;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.type.Comparator;
import org.bukkit.block.data.type.Comparator.Mode;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public enum Type {
    /**
     * Traditional types.
     */
    
    DOUBLE_PLANT(LARGE_FERN, LILAC, PEONY, ROSE_BUSH, SUNFLOWER, TALL_GRASS),
    
    /**
     * <code>GRASS</code> and <code>GRASS_BLOCK</code><br>This is ambiguous.
     */
    GRASS(Material.GRASS, GRASS_BLOCK),
    
    LEAVES(JUNGLE_LEAVES, OAK_LEAVES, SPRUCE_LEAVES, BIRCH_LEAVES, DARK_OAK_LEAVES, ACACIA_LEAVES),
    
    DIRT(Material.DIRT, COARSE_DIRT, PODZOL),
    
    SAND(Material.SAND, RED_SAND),
    
    AIR(Material.AIR, VOID_AIR, CAVE_AIR),
    
    LOG(BIRCH_LOG, BIRCH_WOOD, JUNGLE_LOG, JUNGLE_WOOD, OAK_LOG, OAK_WOOD, SPRUCE_LOG, SPRUCE_WOOD, ACACIA_LOG, ACACIA_WOOD, DARK_OAK_LOG, DARK_OAK_WOOD),
    
    WOOL(BLACK_WOOL, BLUE_WOOL, BROWN_WOOL, CYAN_WOOL, GRAY_WOOL, GREEN_WOOL, LIGHT_BLUE_WOOL, LIGHT_GRAY_WOOL, LIME_WOOL, MAGENTA_WOOL, ORANGE_WOOL, PINK_WOOL, PURPLE_WOOL, RED_WOOL, WHITE_WOOL, YELLOW_WOOL),
    
    /**
     * <code>POLISHED_STONE</code><br>There are no polished stones.
     */
    STONE(Material.STONE, GRANITE, DIORITE, ANDESITE),
    
    /**
     * Data types.
     */
    
    REDSTONE_COMPARATOR_ON(Material.COMPARATOR, (data) -> ((Comparator) data).getMode() == Mode.COMPARE),
    
    REDSTONE_COMPARATOR_OFF(Material.COMPARATOR, (data) -> ((Comparator) data).getMode() == Mode.SUBTRACT),
    
    FALLING_WATER(Material.WATER, (data) -> ((Levelled) data).getLevel() > 7),
    
    STATIONARY_WATER(Material.WATER, (data) -> ((Levelled) data).getLevel() < 8),
    
    WATER_SOURCE(Material.WATER, (data) -> ((Levelled) data).getLevel() == 0),
    
    ORE(COAL_ORE, IRON_ORE, LAPIS_ORE, GOLD_ORE, EMERALD_ORE, DIAMOND_ORE),
    
    /**
     * New types.
     */
    
    POLISHED_STONE(SMOOTH_STONE, POLISHED_GRANITE, POLISHED_DIORITE, POLISHED_ANDESITE),
    
    WOOD(BIRCH_WOOD, JUNGLE_WOOD, OAK_WOOD, SPRUCE_WOOD, ACACIA_WOOD, DARK_OAK_WOOD),
    
    PICKAXE(WOODEN_PICKAXE, IRON_PICKAXE, GOLDEN_PICKAXE, DIAMOND_PICKAXE),
    
    LIGHT_EMITTER(TORCH, REDSTONE_TORCH, GLOWSTONE, SEA_LANTERN, JACK_O_LANTERN, Material.END_ROD, ENDER_CHEST, LAVA_BUCKET),
    
    /**
     * Aliases.
     */
    
    /**
     * <code>FERN</code><br>This is an alias.
     */
    LONG_GRASS(FERN),
    
    /**
     * <code>DANDELION</code><br>This is an alias.
     */
    YELLOW_FLOWER(DANDELION),
    
    /**
     * <code>LILY_PAD</code><br>This is an alias.
     */
    WATER_LILY(LILY_PAD),
    
    /**
     * <code>NETHER_PORTAL</code><br>This is an alias.
     */
    PORTAL(NETHER_PORTAL),
    
    /**
     * <code>GUNPOWDER</code><br>This is an alias.
     */
    SULPHUR(GUNPOWDER),
    
    /**
     * <code>VINE</code><br>This is an alias.
     */
    VINE(Material.VINE),
    
    /**
     * <code>GRAVEL</code><br>This is an alias.
     */
    GRAVEL(Material.GRAVEL),
    
    /**
     * <code>WATER</code><br>This is an alias.
     */
    WATER(Material.WATER, Attribute.ENVELOP),
    
    /**
     * <code>COMPARATOR</code><br>This is an alias.
     */
    COMPARATOR(Material.COMPARATOR, Attribute.ENVELOP),
    
    /**
     * <code>OBSERVER</code><br>This is an alias.
     */
    OBSERVER(Material.OBSERVER),
    
    /**
     * <code>IRON_BARS</code><br>This is an alias.
     */
    IRON_FENCE(IRON_BARS),
    
    /**
     * <code>END_ROD</code><br>This is an alias.
     */
    END_ROD(Material.END_ROD),
    
    /**
     * <code>FIRE</code><br>This is an alias.
     */
    FIRE(Material.FIRE),
    
    /**
     * <code>CAULDRON</code><br>This is an alias.
     */
    CAULDRON(Material.CAULDRON),
    
    /**
     * <code>COBBLESTONE_WALL</code><br>This is an alias.
     */
    COBBLE_WALL(COBBLESTONE_WALL),
    
    /**
     * <code>OBSIDIAN</code><br>This is an alias.
     */
    OBSIDIAN(Material.OBSIDIAN),
    
    /**
     * <code>FURNACE</code><br>This is an alias.
     */
    FURNACE(Material.FURNACE),
    
    /**
     * <code>STICKY_PISTON</code><br>This is an alias.
     */
    STICKY_PISTON_BASE(Material.STICKY_PISTON),
    
    /**
     * <code>PISTON</code><br>This is an alias.
     */
    PISTON_BASE(Material.PISTON),
    
    /**
     * <code>LEVER</code><br>This is an alias.
     */
    LEVER(Material.LEVER),
    
    /**
     * Bad types.
     */
    
    /**
     * This type have not been covered yet.
     */
    OTHERS,
    
    /**
     * This type is not what you wanted.
     */
    UNWANTED;
    
    /**
     * Public area.
     */
    
    @Nondata
    public final static boolean is(Material material, Type type) {
        return type.is(material);
    }
    
    @Nondata
    public final boolean is(Material material) {
        return predicate.is(material);
    }
    
    @Nondata
    public final boolean is(Material material, Type... types) {
        for (Type type : types)
            if (type.is(material))
                return true;
        
        return false;
    }
    
    @Nondata
    public final static Type of(Material material) {
        Set<Type> types = TypeUnit.reverseMap.get(material);
        
        switch (types.size()) {
            case 0:
                return OTHERS;
            case 1:
                return types.iterator().next();
            default:
                return UNWANTED;
        }
    }
    
    @Nondata
    public final static Type of(Material material, Attribute attribute) {
        Set<Type> types = TypeUnit.reverseMap.get(material);
        
        switch (types.size()) {
            case 0:
                return OTHERS;
            case 1:
                Type silverLining = types.iterator().next();
                return silverLining.attribute == attribute ? silverLining : UNWANTED;
            default:
                for (Type type : types)
                    if (type.attribute == attribute)
                        return type;
                return Type.UNWANTED;
        }
    }
    
    public final static boolean is(BlockData data, Type type) {
        return type.is(data);
    }
    
    public final static boolean is(BlockData data, Type... types) {
        for (Type type : types)
            if (type.is(data))
                return true;
        
        return false;
    }
    
    public final boolean is(BlockData data) {
        return predicate.is(data.getMaterial()) ? (hasData ? predicateData.is(data) : true) : false;
    }
    
    public final static Type of(BlockData data) {
        Set<Type> types = TypeUnit.reverseMap.get(data.getMaterial());
        
        if (types == null)
            return OTHERS;
        
        Type optimum = UNWANTED;
        for (Type type : types)
            if (type.is(data))
                if (optimum == null)
                    optimum = type;
                else if (type.hasData)
                        optimum = type;
        
        return optimum;
    }
    
    public final static Type of(BlockData data, Attribute attribute) {
        Set<Type> types = TypeUnit.reverseMap.get(data.getMaterial());
        
        if (types == null)
            return OTHERS;
        
        for (Type type : types)
            if (type.attribute == attribute && type.is(data))
                return type;
        
        return UNWANTED;
    }
    
    /**
     * You may will get an unaccurate or unwanted result.
     * @see UNWANTED
     */
    @Documented
    public static @interface Nondata {
    }
    
    public enum Attribute {
        MAPPING,
        ENVELOP,
        UNWANTED;
    }
    
    /**
     * Hidden infrastructures.
     */
    
    private final Attribute attribute;

    private final TrueType<Material> predicate;

    private boolean hasData;
    private TrueType<BlockData> predicateData;

    private Type() {
        attribute = Attribute.UNWANTED;
        predicate = TypeUnit.of((in) -> false);
    }

    private Type(Material material, TrueType<BlockData> dataPredicate) {
        this(material, Attribute.MAPPING);
        predicateData = dataPredicate;
    }
    
    private Type(Material material) {
        this(material, Attribute.MAPPING);
    }
    
    private Type(Material material, Attribute typeAttribute) {
        attribute = typeAttribute;
        predicate = TypeUnit.of((in) -> material == in);
        reverseType(material);
    }

    private Type(Material... materials) {
        attribute = Attribute.ENVELOP;
        predicate = TypeUnit.of((in) -> contains(materials, in));
        
        for (Material material : materials)
            reverseType(material);
    }

    private final void reverseType(Material key) {
        Set<Type> types = TypeUnit.reverseMap.get(key);
        
        if (types == null) {
            TypeUnit.reverseMap.put(key, Sets.newHashSet(this));
        } else {
            types.add(this);
        }
    }
    
    private final void preTouch() {
    }
    
    static {
        for (Type type : Type.values())
            type.preTouch();
        
        TypeUnit.reverseMap = Maps.transformValues(TypeUnit.reverseMap, (types) -> EnumSet.copyOf(types));
    }

    private static final boolean contains(Material[] array, Material dest) {
        for (Material material : array)
            if (material == dest)
                return true;
        
        return false;
    }

    @FunctionalInterface
    private interface TrueType<T> {
        boolean is(T material);
    }

    private static final class TypeUnit {
        private static Map<Material, Set<Type>> reverseMap = new EnumMap<Material, Set<Type>>(Material.class);
        
        private final static <T> TrueType<T> of(TrueType<T> predicate) {
            return predicate;
        }
    }
}
