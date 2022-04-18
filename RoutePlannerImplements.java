import java.util.Arrays;

public class RoutePlannerImplements {
	
	public void showDetails(String routes[]) {
		for(String row:routes) {
			String column[] = row.split(",");
			for(String col:column) {
				System.out.printf("%-20s",col);
			}
			System.out.println();
		}
	}
	
	public void showDirectFlights(String routeInfo[],String fromCity) {
		String directFlights[] = new String[0];
		int count = 0;
		for(String row:routeInfo) {
			String column[] = row.split(",");
			if(column[0].equalsIgnoreCase(fromCity)) {
				count++;
			}
		}
		directFlights = new String[count];
		if(count == 0) {
			System.out.println("We are sorry. At this point of time, we do not have any information on flights originating from "+fromCity+".");
		}
		else {
			int i=0;
			for(String row:routeInfo) {
				String column[] = row.split(",");
				if(column[0].equalsIgnoreCase(fromCity)) {
					directFlights[i] = row;
					i++;
			}
			}
			String column[] = routeInfo[0].split(",");
			for(String col:column) {
				System.out.printf("%-20s", col);
			}
			System.out.println();
			sortDirectFlights(directFlights);
		}
	}
	
	public void sortDirectFlights(String directFlights[]) {
		Arrays.sort(directFlights);
		for(String row:directFlights) {
			String column[] = row.split(",");
			for(String col:column) {
				System.out.printf("%-20s", col);
			}
			System.out.println();
		}
	}
	
	public void showAllConnections(String routeInfo[],String fromCity,String Tocity) {
		boolean b = false;
		for(String row:routeInfo) {
			String column[] = row.split(",");
			if(column[0].equalsIgnoreCase(fromCity) && column[1].equalsIgnoreCase(Tocity)) {
				if(!b) {
					b = true;
					String temp[] = routeInfo[0].split(",");
					for(String i:temp) {
						System.out.printf("%-20s", i);
					}
					System.out.println();
				}
				for(String col:column) {
					System.out.printf("%-20s", col);
				}
				System.out.println();
			}
		}
		for(String row:routeInfo) {
			String column[] = row.split(",");
			if(column[0].equalsIgnoreCase(fromCity) && !column[1].equalsIgnoreCase(Tocity)) {
				String tempCity = column[1];
				for(String i:routeInfo) {
					String j[] = i.split(",");
					if(tempCity.equalsIgnoreCase(j[0]) && j[1].equalsIgnoreCase(Tocity)) {
						if(!b) {
							b = true;
							String temp[] = routeInfo[0].split(",");
							for(String k:temp) {
								System.out.printf("%-20s", k);
							}
							System.out.println();
						}
						for(String col:column) {
							System.out.printf("%-20s",col);
						}
						System.out.println();
						for(String col:j) {
							System.out.printf("%-20s", col);
						}
						System.out.println();
					}
				}
			}
		}
		if(!b) {
			System.out.println("We are sorry. At this point of time, we do not have any information on flights originating from "+fromCity+".");
		}
	}
}