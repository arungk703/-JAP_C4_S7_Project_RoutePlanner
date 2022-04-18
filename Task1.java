import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {

	public static void main(String[] args) throws IOException {
		String file = "src\\routes.csv";
		BufferedReader reader = null;
		String line = "";
		String routes[];
			reader = new BufferedReader(new FileReader(file));
			int count = 0;
			while((line = reader.readLine()) != null) {
				count++;
			}
			reader.close();
			reader = new BufferedReader(new FileReader(file));
			routes = new String[count];
			line = "";
			int i=0;
			while((line = reader.readLine()) != null) {
				routes[i] = line;
				i++;
			}
			reader.close();
		RoutePlannerImplements obj = new RoutePlannerImplements();
		//System.out.println("All Flight Details: ");
		//obj.showDetails(routes);
		//obj.showDirectFlights(routes, "Delhi");
		//obj.sortDirectFlights(routes);
		obj.showAllConnections(routes, "Delhi", "London");
	}

}
