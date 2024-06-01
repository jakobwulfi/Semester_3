public class opg6 {
    public static void main(String[] args) {
        char[] chars = { 'G', 'R', 'S', 'G', 'G', 'R', 'S', 'R', 'G', 'G', 'R', 'S', 'G' };
        belgisk_flag(chars);
        System.out.println(chars);
    }

    /**
     * Du skal lave en metode der givet et belgisk_flag af tegn (de tre tegn ’S’, ’G’ og ’R’) bytter
     * rundt på tegnene så først kommer alle de sorte ’S’, så de gule ’G’ og til sidst de
     * røde ’R’, svarende til det belgiske fag.
     * Såfremt belgisk_flaget har følgende udseende ved start
     * { G, R, S, G, G, R, S, R, G, G, R, S, G }
     * Vil elementerne være byttet rundt så belgisk_flaget får følgende udseende
     * { S, S, S, G, G, G, G, G, G, R, R, R, R}
     * Du kan ikke vide hvor mange der er af hver farve.
     */
    public static void belgisk_flag(char[] belgisk_flag) {
        int sIndex = 0;  // Dette indeks holder styr på positionen for 'S'
        int gIndex = 0;  // Dette indeks bruges til at iterere gennem arrayet
        int rIndex = belgisk_flag.length - 1;  // Dette indeks holder styr på positionen for 'R'

        while (gIndex <= rIndex) {
            switch (belgisk_flag[gIndex]) {
                case 'S':
                    // Swap elementerne på positionerne sIndex og gIndex
                    swap(belgisk_flag, sIndex++, gIndex++);
                    break;
                case 'G':
                    // Hvis det er 'G', rykker vi bare gIndex fremad
                    gIndex++;
                    break;
                case 'R':
                    // Swap elementerne på positionerne gIndex og rIndex
                    swap(belgisk_flag, gIndex, rIndex--);
                    break;
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
