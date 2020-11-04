package pl.SeVeT.bankApp.utils;

import java.math.BigInteger;
import java.util.Random;

public class Generator {
    public static BigInteger accNumber(){
        BigInteger lowBar = new BigInteger("10000000000000000000000000");
        BigInteger highBar = new BigInteger("99999999999999999999999999");
        Random random = new Random();
        int length = highBar.bitLength();
        BigInteger accNumber = new BigInteger(length,random);
        if(accNumber.compareTo(lowBar)>=0) accNumber = accNumber.mod(accNumber).add(lowBar);
        else accNumber = accNumber.add(lowBar);
        return accNumber;
    }

}
