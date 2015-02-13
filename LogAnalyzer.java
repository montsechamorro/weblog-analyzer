/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.  ///c�lculo de los recuentos de acceso por hora
    private int[] hourCounts;
    // Use a LogfileReader to access the data.  ///usa un logfilereader para acceder a los datos
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     * 
     * //crear objeto para analizar los accesos web por hora
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * constructor que se pasa parametro del nombre del archivo log a analizar, creado con LogFileCreator
     */
    public LogAnalyzer(String filename)
    {
        hourCounts = new int[24];
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.  
     * 
     * //Analizar los datos de acceso por hora desde el archivo de registro
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * metodo que devuelve el numero total de accesos al servidor web registrados
     * e el archivo de log
     */
    public int numberOfAccesses()
    {
        int totalAccesos = 0;
        int hour = 0;
         while( hour < hourCounts.length)
        {
            totalAccesos = hourCounts[hour];
            hour++;
        }        
        
        return totalAccesos;
    }

    /**
     * Print the hourly counts.
     * // imprime los conteos por hora
     * These should have been set with a prior 
     * //deben haber sido creados con anterioridad
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;

        while( hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }

    /**
     * Print the lines of data read by the LogfileReader
     * //Imprimir las l�neas de datos le�dos por el LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
