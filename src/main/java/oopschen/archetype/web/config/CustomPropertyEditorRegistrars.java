package oopschen.archetype.web.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.text.SimpleDateFormat;

/**
 * <p>Custom Property Editor</p>
 *
 * @author ray
 * @date 2015.08.02
 * @since 1.0
 */
public class CustomPropertyEditorRegistrars implements PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // string trim
        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        // date
        registry.registerCustomEditor(java.util.Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

    }
}
