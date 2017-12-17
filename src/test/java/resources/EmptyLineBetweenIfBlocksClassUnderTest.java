package com.nikosmoum.ext.checks;

import java.util.List;

/**
 * Test code for checker class {@link EmptyLineBetweenIfBlocks}
 * @author Nikolaos Moumoulidis
 *
 */
public class EmptyLineBetweenIfBlocksClassUnderTest {

    public void methodWithTwoIfBlocksSharingTheSameLine() {
        if (true) {
            boolean a = true;
        }
        else {
            boolean a = true;
            boolean b = true;
        } if (true) {
            boolean a = true;
        }
    }

    public void methodWithTwoIfBlocksWithoutEmptyLineInBetween() {
        if (true) {
            boolean a = true;
        }
        else {
            boolean a = true;
            boolean b = true;
        }
        if (true) {
            boolean a = true;
        }
    }

    public void methodWithTwoIfBlocksWithEmptyLineInBetween() {
        if (true) {
            boolean a = true;
        }

        if (true) {
            boolean a = true;
        }
    }

    public void methodWithTwoIfBlocksWithMultipleEmptyLinesInBetween() {
        if (true) {
            boolean a = true;
        }



        if (true) {
            boolean a = true;
        }
    }

    public void methodWithOneIfBlock() {
        boolean x = true;
        if (x) {
            x = false;
        }
    }

    public void methodWithoutIfBlocks() {
        boolean x = true;
        List<Boolean> randomList;
    }
}
