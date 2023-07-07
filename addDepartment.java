public static void addDepartment(Scanner keyin) {
        System.out.println();
        System.out.println("ADD NEW DEPARTMENT");

        if (companies.isEmpty()) {
            System.out.println("No companies found.");
            pressEnter(keyin);
            return;
        }

        System.out.print("Department Name: ");
        String departmentName = keyin.nextLine();

        System.out.println();
        //System.out.println("Available Companies:");
        for (int i = 0; i < companies.size(); i++) {
            System.out.println((i + 1) + " - " + companies.get(i).getName());
        }

        System.out.print("Choose company to add department: ");
        int companyIndex = Integer.parseInt(keyin.nextLine()) - 1;

        if (companyIndex < 0 || companyIndex >= companies.size()) {
            System.out.println("Invalid company selection.");
            pressEnter(keyin);
            return;
        }