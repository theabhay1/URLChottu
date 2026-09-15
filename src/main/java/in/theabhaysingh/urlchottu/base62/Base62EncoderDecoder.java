package in.theabhaysingh.urlchottu.base62;

public class Base62EncoderDecoder {
    public String encode(long num) {
        if(num == 0) {
            return "0";
        }
        StringBuilder encodedValue = new StringBuilder();

        while(num > 0) {
            char currCharacter;
            int currValue = (int) (num % 62);

            if(currValue <= 9) {
                currCharacter = (char) (currValue + '0');
            }
            else if(currValue <= 35) {
                int position = currValue - 10;

                currCharacter = (char) ('a' + position);
            }
            else {
                int position = currValue - 36;

                currCharacter = (char) ('A' + position);
            }

            num /= 62;

            encodedValue.append(currCharacter);
        }

        return encodedValue.reverse().toString();
    }
    public long decode(String encoded) {
        long decodedValue = 0;
        long multiplier = 1;

        for(int i = encoded.length() -1; i >= 0; --i) {
            char curr = encoded.charAt(i);
            long decimalValue;

            if(curr >= '0' && curr <= '9') {
                decimalValue = curr - '0';
            }
            else if(curr >= 'a' && curr <= 'z') {
                decimalValue = 10 + (curr - 'a');
            }
            else {
                decimalValue = 36 + (curr - 'A');
            }

            decodedValue += (decimalValue) * (multiplier);
            multiplier *= 62;
        }

        return decodedValue;
    }
}
