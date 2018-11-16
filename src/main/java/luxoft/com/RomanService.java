package luxoft.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RomanService {

    private static final Logger log = LoggerFactory.getLogger(RomanService.class);

    private final List<Roman> container;

    private final Map<String, Integer> dictionary;

    public RomanService(){
        container = Arrays.asList(
                new Roman("I", RomanConst.I),
                new Roman("V", RomanConst.V),
                new Roman("X", RomanConst.X),
                new Roman("L", RomanConst.L),
                new Roman("C", RomanConst.C),
                new Roman("D", RomanConst.D),
                new Roman("M", RomanConst.M));
        dictionary = new HashMap<>();
        container.forEach(roman -> dictionary.put(roman.getSymbol(), roman.getValue()));
    }

    public int convert(String room) {

        List<Integer> arr = new ArrayList();

        char[] ch = room.toCharArray();

        for(int i = 0; i<=ch.length-1; i++){
//            dictionary.get calling this multiple time is issue, we can use entrySet on iteration which all element is available
//            but I need iterate on ch array
            if(i!=ch.length-1 && (dictionary.get(String.valueOf(ch[i+1])) == null || dictionary.get(String.valueOf(ch[i])) == null)) throw new RomanException("Wrong symbol in a sequence!");
            int curVal;
            int mod = -1;
            curVal = dictionary.get(String.valueOf(ch[i]));

            if(i!=ch.length-1 && dictionary.get(String.valueOf(ch[i])) < dictionary.get(String.valueOf(ch[i+1]))){
                curVal*=mod;
            }
            log.info("Current symbol : {},  val is : {}", String.valueOf(ch[i]) ,curVal);
            arr.add(curVal);
        }

        return arr.stream().mapToInt(i->i.intValue()).sum();

    }
}
