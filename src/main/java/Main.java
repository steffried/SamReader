import htsjdk.samtools.*;

import java.io.File;
import java.util.Scanner;

/**
 * Created by stef on 18.06.2015.
 */
public class Main {

    public static void main(String [] args) {

        File file = new File("C:/Users/stef/Programs/BAM/U251_seq.sam");
        final File outFile = new File ( "C:/Users/stef/Programs/BAM/U251_seq_new.sam");

        final SamReader reader = SamReaderFactory.makeDefault().open(file);

        final SAMFileWriter outputSam = new SAMFileWriterFactory().makeSAMOrBAMWriter(reader.getFileHeader(),
                true, outFile);


        Integer line = 4;
        for (SAMRecord record: reader) {
            line++;
            Integer cigarLength = record.getCigar().getReferenceLength();
            Integer readLength = record.getReadString().length();

            if (cigarLength > (readLength - 10) && cigarLength < (readLength + 10)) {
                outputSam.addAlignment(record);
            }
            else {
                System.out.println(line++ + " - " + readLength + " ; " + cigarLength + " " + record.getCigar().toString());
            }
        }





    }
}
