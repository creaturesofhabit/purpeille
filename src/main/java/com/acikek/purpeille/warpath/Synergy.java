package com.acikek.purpeille.warpath;

public enum Synergy {

    OPPOSITION(-1.0),
    NEUTRAL(1.0),
    TONE(1.5),
    IDENTICAL(1.75);

    public double modifier;

    Synergy(double modifier) {
        this.modifier = modifier;
    }

    public static Synergy getSynergy(Revelation revelation, Aspect aspect) {
        if (aspect == null) {
            return null;
        }
        if (revelation.tone.getOpposition() == aspect.tone) {
            return OPPOSITION;
        }
        if (revelation.tone == aspect.tone) {
            return revelation.index == aspect.index ? IDENTICAL : TONE;
        }
        return NEUTRAL;
    }
}