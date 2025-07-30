package dev.tankpillow.cosmicraft.misc.cape;

import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dev.tankpillow.cosmicraft.Cosmicraft;
import net.minecraft.util.Identifier;

public class CapeManager {
	
	private static class CapeEntry {
		String uuid;
		String cape;
	}
	
	private static final String CAPES_URL = "https://raw.githubusercontent.com/tankpillow/Cosmicraft/refs/heads/master/capes.json";
	private static final Map<UUID, String> CAPES = new HashMap<>();
	private static boolean loaded = false;
	
	private static void loadCapes() {
		if(loaded) {
			return;
		}
		loaded = true;
		try {
			URI uri = URI.create(CAPES_URL);
			URL url = uri.toURL();
			InputStreamReader reader = new InputStreamReader(url.openStream());
            List<CapeEntry> entries = new Gson().fromJson(reader, new TypeToken<List<CapeEntry>>(){}.getType());
            for (CapeEntry entry : entries) {
                CAPES.put(UUID.fromString(entry.uuid), entry.cape);
            }
		} catch(Exception e) {
			Cosmicraft.LOGGER.error("Failed to load capes.json");
		}
	}
	
	public static Identifier getCapeForUUID(UUID uuid) {
		loadCapes();
		String capeId = CAPES.get(uuid);
		if(capeId != null) {
			return Identifier.of(Cosmicraft.MOD_ID, "textures/cape/cape_" + capeId + ".png");
		}
		return null;
	}
}
