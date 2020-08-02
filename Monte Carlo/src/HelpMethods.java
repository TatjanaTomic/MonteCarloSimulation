import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpMethods {
	public static boolean provjeriBrojVrijednosti(String string)
	{
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(string);
		
		if(matcher.matches()) 
		{
			return true;
		}
		else
			return false;
	}
}
