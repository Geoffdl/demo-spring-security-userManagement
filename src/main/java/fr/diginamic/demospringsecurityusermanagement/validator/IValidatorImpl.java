package fr.diginamic.demospringsecurityusermanagement.validator;

import fr.diginamic.demospringsecurityusermanagement.exception.ProblemException;
import org.springframework.stereotype.Component;

/**
 * Implémentation du validateur
 */
@Component
public class IValidatorImpl implements IValidator
{
    @Override
    public void isTrue(boolean condition, String errorMessage) throws ProblemException
    {
        if (!condition)
        {
            throw new ProblemException(errorMessage);
        }
    }
}
