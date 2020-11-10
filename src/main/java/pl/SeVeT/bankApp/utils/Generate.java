package pl.SeVeT.bankApp.utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generate {
    public static BigInteger accNumber() {
        StringBuilder builder = new StringBuilder();
        builder.append(ThreadLocalRandom.current().nextInt(1,10));
        do{
            builder.append(ThreadLocalRandom.current().nextInt(0,10));
        }while(builder.toString().length()<25);
        builder.append(ThreadLocalRandom.current().nextInt(1,10));
        BigInteger accNumber = new BigInteger(builder.toString());
        return accNumber.subtract(BigInteger.valueOf(1));
    }
}
