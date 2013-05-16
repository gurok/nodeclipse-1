package org.nodeclipse.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nodeclipse.ui.Activator;

/**
 * @author Tomoyuki Inagaki
 * @author Paul Verest
 */
public class NodePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private FileFieldEditor fileFieldEditor;
    private FileFieldEditor expressPath;
    private FileFieldEditor completionsPath;
    private ColorFieldEditor colorComment;
    private ColorFieldEditor colorDoc;
    private ColorFieldEditor colorKeyword;
    private ColorFieldEditor colorString;
    private ColorFieldEditor colorNumber;
    private ColorFieldEditor colorNormal;
    private BooleanFieldEditor boldAttributeKeyword;
    
    public NodePreferencePage() {
        super(GRID);
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        setPreferenceStore(store);
        setDescription("Node Settings");
    }

    @Override
    public void init(IWorkbench workbench) {

    }

    @Override
    protected void createFieldEditors() {
    	Composite parent = getFieldEditorParent();

        fileFieldEditor = new FileFieldEditor(PreferenceConstants.KEY_NODE_PATH, "Node Path:", parent);
        addField(fileFieldEditor);
        
        expressPath = new FileFieldEditor(PreferenceConstants.KEY_EXPRESS_PATH, "Express Path:", parent);
        addField(expressPath);

        completionsPath = new FileFieldEditor(PreferenceConstants.KEY_COMPLETIONS_JSON_PATH, "Completions.json Path:", parent);
        addField(completionsPath);

        colorComment = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_COMMENT, "Comment color:", parent);
        addField(colorComment);

        colorDoc = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_DOC, "Doc color:", parent);
        addField(colorDoc);

        colorKeyword = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_KEYWORD, "Keyword color:", parent);
        addField(colorKeyword);

        boldAttributeKeyword = new BooleanFieldEditor(PreferenceConstants.KEY_BOLD_KEYWORD, "Bold keywords", parent);
        addField(boldAttributeKeyword);

        colorString = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_STRING, "String color:", parent);
        addField(colorString);

        colorNumber = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_NUMBER, "Number color:", parent);
        addField(colorNumber);

        colorNormal = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_NORMAL, "Normal text color:", parent);
        addField(colorNormal);
    }

    public boolean performOk() {
    	boolean result = super.performOk();
    	if(result) {
    		
    	}

    	return result;
    }

    @Override
    public boolean isValid() {
        return super.isValid();
    }

}