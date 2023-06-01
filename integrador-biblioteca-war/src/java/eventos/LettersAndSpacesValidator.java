/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package eventos;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("custom.lettersAndSpacesValidator")
public class LettersAndSpacesValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String text = (String) value;
        if (!text.matches("[A-Za-z ]+")) {
            FacesMessage message = new FacesMessage("Solo se permiten letras y espacios en blanco.");
            throw new ValidatorException(message);
        }
    }
}

