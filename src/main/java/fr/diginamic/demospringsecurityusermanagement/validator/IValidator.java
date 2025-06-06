package fr.diginamic.demospringsecurityusermanagement.validator;

import fr.diginamic.demospringsecurityusermanagement.exception.ProblemException;

/**
 * Interface de validation de donnée
 */
public interface IValidator
{
    /**
     * Test de validation, le test en parametre doit etre valide, sinon la methode jette une exception
     * @param condition    test valide à confirmer
     * @param errorMessage message d'erreur le cas échéant
     * @throws ProblemException le test a échoué
     */
    void isTrue(boolean condition, String errorMessage) throws ProblemException;
}
