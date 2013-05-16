package org.nodeclipse.ui.preferences;

import org.eclipse.swt.graphics.RGB;

/**
 * Constant definitions for plug-in preferences
 * 
 * @author Tomoyuki Inagaki
 * @author Paul Verest
 */
public class PreferenceConstants {

	public static final String PREFERENCES_PAGE = "org.nodeclipse.ui.preferences.NodePreferencePage";

	public static final String KEY_NODE_PATH = "node_path";
	public static final String KEY_EXPRESS_PATH = "express_pass";
	public static final String KEY_EXPRESS_VERSION = "express_version";
	public static final String KEY_COMPLETIONS_JSON_PATH = "completionsjson_path";

	public static final String KEY_COLOR_COMMENT = "color_comment";
	public static final String KEY_COLOR_DOC = "color_doc";
	public static final String KEY_COLOR_KEYWORD = "color_keyword";
	public static final String KEY_COLOR_STRING = "color_string";
	public static final String KEY_COLOR_NUMBER = "color_number";
	public static final String KEY_COLOR_NORMAL = "color_normal";

	public static final String KEY_BOLD_KEYWORD = "bold_keyword";

	public static final RGB DEFAULT_COLOR_COMMENT = new RGB(63, 127, 95);
	public static final RGB DEFAULT_COLOR_DOC = new RGB(127, 127, 159);
	public static final RGB DEFAULT_COLOR_KEYWORD = new RGB(127, 0, 85);
	public static final RGB DEFAULT_COLOR_STRING = new RGB(42, 0, 255);
	public static final RGB DEFAULT_COLOR_NUMBER = new RGB(0, 0, 0);
	public static final RGB DEFAULT_COLOR_NORMAL = new RGB(0, 0, 0);
}
