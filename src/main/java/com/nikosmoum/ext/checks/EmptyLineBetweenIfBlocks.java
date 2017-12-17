package com.nikosmoum.ext.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * A Checkstyle class that logs an error when two consecutive if blocks
 * do not have at least one empty line between them, as such:
 * <pre> <code>
 * if (...) {
 * ...
 * }
 *
 * if (...) {
 * </code> </pre>
 * @author Nikolaos Moumoulidis
 *
 */
public class EmptyLineBetweenIfBlocks extends AbstractCheck {

    @Override
    public void visitToken(DetailAST ast) {
        int currentLastRCURLYLineNumber = 0;
        int currentNextLITERAL_IFLineNumber = 0;

        // Find the last right curly of the if block.
        DetailAST currentLastChild = ast.getLastChild();
        while (currentLastChild.getChildCount() != 0) {
            currentLastChild = currentLastChild.getLastChild();
        }
        currentLastRCURLYLineNumber = currentLastChild.getLineNo();

        // If the next sibling of the if block is another if block, check that
        // there is an empty line between them, otherwise log an error.
        DetailAST currentSibling = ast.getNextSibling();
        if (currentSibling != null && currentSibling.getType() == TokenTypes.LITERAL_IF) {
            currentNextLITERAL_IFLineNumber = currentSibling.getLineNo();

            if (currentNextLITERAL_IFLineNumber == currentLastRCURLYLineNumber ||
                currentNextLITERAL_IFLineNumber == currentLastRCURLYLineNumber + 1) {
                log(currentNextLITERAL_IFLineNumber, String.format("There is no extra line between "
                    + "if block ending at line %d and if block starting at line %d!",
                    currentLastRCURLYLineNumber, currentNextLITERAL_IFLineNumber));
            }
        }
   }

    @Override
    public int[] getDefaultTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getAcceptableTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[]{TokenTypes.LITERAL_IF};
    }
}
