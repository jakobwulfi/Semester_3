package model;

public class Nedboer {
    private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */
    public int bedsteTreFerieUger() {
        int sum = (int) Math.pow(10, 10);
        int weekNr = 0;
        for (int i = 0; i < nedboerPrUge.length - 2; i++) {
            int tempSum = nedboerPrUge[i] + nedboerPrUge[i+1] + nedboerPrUge[i+2];
            if (tempSum < sum) {
                sum = tempSum;
                weekNr = i + 1;
            }
        }
        return weekNr;
    }
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */
    public int bedsteFerieUgerStart(int antal) {
        int sum = (int) Math.pow(10, 10);
        int weekNr = 0;
        for (int i = 0; i < nedboerPrUge.length - antal - 1; i++) {
            int tempSum = 0;
            for (int j = i; j < i + antal; j++) {
                tempSum += nedboerPrUge[j];
            }
            if (tempSum < sum) {
                sum = tempSum;
                weekNr = i + 1;
            }
        }
        return weekNr;
    }
    
    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        int weekNr = 0;
        int count = 0;
        for (int i = 0; i < nedboerPrUge.length; i++) {
            int index = i;
            int tempCount = 0;
            boolean found = false;
            while (!found && index < nedboerPrUge.length) {
                if (nedboerPrUge[i] == nedboerPrUge[index]) {
                    tempCount++;
                    index++;
                } else {
                    found = true;
                }
            }
            if (tempCount > count) {
                count = tempCount;
                weekNr = i;
            }
        }
        return weekNr;
    }
}
