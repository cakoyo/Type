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

import java.util.EnumMap;

import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Material;

public enum Type {
    DOUBLE_PLANT(LARGE_FERN, LILAC, PEONY, ROSE_BUSH, SUNFLOWER, TALL_GRASS),
    
    /**
     * <code>GRASS</code> and <code>GRASS_BLOCK</code><br>This is ambiguous.
     */
    GRASS(Material.GRASS, GRASS_BLOCK),
    
    LEAVES(JUNGLE_LEAVES, OAK_LEAVES, SPRUCE_LEAVES, BIRCH_LEAVES, DARK_OAK_LEAVES, ACACIA_LEAVES),
    
    /**
     * <code>FERN</code><br>This is an alias.
     */
    LONG_GRASS(FERN),
    
    DIRT(Material.DIRT, COARSE_DIRT, PODZOL),
    
    SAND(Material.SAND, RED_SAND),
    
    LOG(BIRCH_LOG, BIRCH_WOOD, JUNGLE_LOG, JUNGLE_WOOD, OAK_LOG, OAK_WOOD, SPRUCE_LOG, SPRUCE_WOOD),
    
    /**
     * <code>POLISHED_STONE</code><br>There are no polished stones.
     */
    STONE(Material.STONE, GRANITE, DIORITE, ANDESITE),
    
    POLISHED_STONE(SMOOTH_STONE, POLISHED_GRANITE, POLISHED_DIORITE, POLISHED_ANDESITE),
    
    /**
     * <code>DANDELION</code><br>This is an alias.
     */
    YELLOW_FLOWER(DANDELION),
    
    /**
     * <code>LILY_PAD</code><br>This is an alias.
     */
    WATER_LILY(LILY_PAD),
    
    /**
     * <code>WATER</code><br>This is an alias.
     */
    STATIONARY_WATER(Material.WATER),
    
    /**
     * <code>WATER</code><br>This is an reference.
     */
    WATER(Material.WATER),
    
    /**
     * <code>VINE</code><br>This is an reference.
     */
    VINE(Material.VINE),
    
    /**
     * <code>GRAVEL</code><br>This is an reference.
     */
    GRAVEL(Material.GRAVEL),
    
    /**
     * This type have not been covered yet.
     */
    TYPE_OVERFLOW;
    
    private final TrueType predicate;
    
    private Type(Material material) {
        predicate = TypeUnit.of((in) -> in == material);
        TypeUnit.reverseMap.put(material, this);
    }
    
    private Type(Material... materials) {
        predicate = TypeUnit.of((in) -> ArrayUtils.contains(materials, in));
        for (Material material : materials)
            TypeUnit.reverseMap.put(material, this);
    }
    
    public boolean is(Material material) {
        return predicate.is(material);
    }
    
    public static Type of(Material material) {
        return TypeUnit.reverseMap.getOrDefault(material, TYPE_OVERFLOW);
    }
    
    public static class TypeUnit implements TrueType {
        private static final EnumMap<Material, Type> reverseMap = new EnumMap<Material, Type>(Material.class);
        private final TrueType predicate;
        
        private TypeUnit(TrueType predicate) {
            this.predicate = predicate;
        }
        
        private static TrueType of(TrueType predicate) {
            return new TypeUnit(predicate);
        }
        
        @Override
        public boolean is(Material material) {
            return predicate.is(material);
        }
    }
}
