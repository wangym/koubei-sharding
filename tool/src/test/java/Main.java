/**
 * 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xuanyin
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String source = "update $store_plus$ set discount='[{\"createTime\":\"2011-03-27 14:14:05\",\"discount\":8.8,\"notes\":\"酒水、海鲜除外，不与其他优惠共享\",\"signManager\":\"\",\"signStatus\":0,\"signTime\":\"\",\"status\":1,\"timeEnd\":\"2012-03-15 00:00:00\",\"timeStart\":\"2011-03-16 00:00:00\",\"type\":1},{\"createTime\":\"2011-03-30 18:00:00\",\"timeStart\":\"2011-03-30 18:00:00\",\"timeEnd\":\"2012-12-28 09:18:04\",\"signTime\":\"\",\"status\":1,\"signStatus\":0,\"signManager\":\"\",\"type\":2,\"notes\":\"\",\"discount\":10},{\"createTime\":\"2011-03-30 18:00:00\",\"timeStart\":\"2011-03-30 18:00:00\",\"timeEnd\":\"2012-12-28 09:18:04\",\"signTime\":\"\",\"status\":1,\"signStatus\":0,\"signManager\":\"\",\"type\":4,\"notes\":\"\",\"discount\":10}]' where id=\"2381ff341fbb4dc9bc3a6e9cc7a18a0d\";";
		Pattern pattern = Pattern.compile("(id=\")(.+?)(\")");
		Matcher matcher = pattern.matcher(source);
		while (matcher.find()) {
			System.out.println(matcher.group(2));
		}
	}
}
