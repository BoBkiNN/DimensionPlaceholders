# DimensionPlaceholders

#Placeholders
* %dimplc_color% 
 if (params.equalsIgnoreCase("color")){
            String color = Main.config.getString("colors."+worldName, "");
            return ChatColor.translateAlternateColorCodes('&', color);
        }
        if (params.equalsIgnoreCase("folder")) return world.getName();
        if (params.equalsIgnoreCase("namespacedkey")) return world.getKey().getNamespace()+":"+world.getKey().getKey();
        if (params.equalsIgnoreCase("namespace")) return world.getKey().getNamespace();
        if (params.equalsIgnoreCase("key")) return world.getKey().getKey();
        if (params.equalsIgnoreCase("loadedchunks")) return String.valueOf(world.getLoadedChunks().length);
