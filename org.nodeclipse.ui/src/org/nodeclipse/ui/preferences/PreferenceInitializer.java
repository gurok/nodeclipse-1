package org.nodeclipse.ui.preferences;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.nodeclipse.ui.Activator;
import org.nodeclipse.ui.util.Constants;
import org.nodeclipse.ui.util.OSUtils;
import org.nodeclipse.ui.util.ProcessUtils;

/**
 * 
 * @author oncereply
 * 
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public PreferenceInitializer() {
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String path = "/usr/local/bin/node";
//		String express_path = "/usr/local/bin/express";
		String express_path = "/usr/local/lib/node_modules/express/bin/express";
		File file;
		if (OSUtils.isWindows()) {
			path = "C:/Program Files/nodejs/node.exe".replace('/', File.separatorChar);
			file = new File(path);
			if (!file.exists()) {
				path = "C:/Program Files (x86)/nodejs/node.exe".replace('/', File.separatorChar);
			}
//			express_path = System.getProperty("user.home") 
//					+ "/AppData/Roaming/npm/express.cmd".replace('/', File.separatorChar);
			express_path = System.getProperty("user.home") 
					+ "/AppData/Roaming/npm/node_modules/express/bin/express".replace('/', File.separatorChar);
		}
		if (OSUtils.isMacOS()) {
			file = new File(path);
			if (!file.exists()) {
				path = "/opt/local/bin/node";
			}
			file = new File(express_path);
			if (!file.exists()) {
//				express_path = "/opt/local/bin/express";
				express_path = "/opt/local/lib/node_modules/express/bin/express";
			}
		}
		file = new File(path);
		if (file.exists()) {
			store.setDefault(PreferenceConstants.KEY_NODE_PATH, path);
		}
		file = new File(express_path);
		if (file.exists()) {
			store.setDefault(PreferenceConstants.KEY_EXPRESS_PATH, express_path);
			store.setDefault(PreferenceConstants.KEY_EXPRESS_VERSION,
					getExpressVersion(express_path));
		}
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_COMMENT, PreferenceConstants.DEFAULT_COLOR_COMMENT);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_DOC, PreferenceConstants.DEFAULT_COLOR_DOC);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_KEYWORD, PreferenceConstants.DEFAULT_COLOR_KEYWORD);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_STRING, PreferenceConstants.DEFAULT_COLOR_STRING);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_NUMBER, PreferenceConstants.DEFAULT_COLOR_NUMBER);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_NORMAL, PreferenceConstants.DEFAULT_COLOR_NORMAL);
        store.setDefault(PreferenceConstants.KEY_BOLD_KEYWORD, true);
	}

	private String getExpressVersion(String express) {
		List<String> cmdLine = new ArrayList<String>();
		cmdLine.add(ProcessUtils.getNodePath());
		cmdLine.add(ProcessUtils.getExpressPath());
		cmdLine.add("--version");
		String ret = Constants.BLANK_STRING;
		try {
			ret = ProcessUtils.exec(cmdLine, null);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return ret;
	}
}