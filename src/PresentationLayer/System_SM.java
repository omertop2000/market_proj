package PresentationLayer;

import java.sql.SQLException;
import java.util.Scanner;

import ServiceLayer.Jsoncontroller;
import ServiceLayer.Service;
import com.google.gson.JsonObject;
import DomainLayer.Supply;

public class System_SM {
    private Jsoncontroller jcontroller;
    private String in;
    public String userName;
    private String out;
    public Service service;
    private Scanner scanner;

    public System_SM(Jsoncontroller jc){
        this.jcontroller = jc;
    }

    public void print_menu_manager() throws SQLException {
        System.out.println("************************************************************");
        System.out.println("            Hello SM, please choose an option:");
        System.out.println("************************************************************");
        System.out.print("Hello, please choose one option from the following:\n");
        System.out.print("1.Get item location\n");
        System.out.print("2.Get item manufacturer\n");
        System.out.print("3.Get current amount of item type\n");
        System.out.print("4.Get current amount of item type on shelves\n");
        System.out.print("5.Get current amount of item type in storage\n");
        System.out.print("6.Get selling item price \n");
        System.out.print("7.Get cost price of item type \n");
        System.out.print("8.Get current supply report on specific category\n");
        System.out.print("9.Get current faulty item report \n");
        System.out.print("10.Pass days in system\n");
        System.out.print("11.Enter sale for items\n");
        System.out.print("12.Set minimal amount of item type\n");
        System.out.print("13.Enter sale for category or categories\n");
        System.out.print("14.Add new area to shop\n");
        System.out.print("15.Add shelf to specific area\n");
        System.out.print("16.Get sale from supplier on item type\n");
        System.out.print("17.Set new supplier sale of item type\n");
        System.out.print("18.Set new selling price of item type\n");
        System.out.print("19.Set new cost price of item type\n");
        System.out.print("20.Get current supply report on category or categories\n");
        System.out.print("21.Exit \n");
        System.out.println("************************************************************");
        get_answer_manager();
    }

    public void get_answer_manager() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int user_input = scanner.nextInt();
        switch (user_input) {
            case 1 -> {
                System.out.print("Enter the serial number of the item \n");
                int user_input1 = scanner.nextInt();
                JsonObject json1 = new JsonObject();
                json1.addProperty("serialnumber", user_input1);
                System.out.print(jcontroller.get_item_location(json1));
                print_menu_manager();
            }
            case 2 -> {
                System.out.print("Enter the serial number of the item \n");
                int user_input1 = scanner.nextInt();
                JsonObject json2 = new JsonObject();
                json2.addProperty("serialnumber", user_input1);
                System.out.print(jcontroller.get_item_manufacturer(json2));
                print_menu_manager();
            }
            case 3 -> {
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                JsonObject json3 = new JsonObject();
                json3.addProperty("type_id", type_id);
                int cur_amount = jcontroller.get_cur_amount_type(json3);
                if(cur_amount == -1){
                    System.out.print("Type not exist\n");
                }
                else{
                    System.out.print(cur_amount);
                    System.out.print("\n");
                }
                print_menu_manager();
            }
            case 4 -> {
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                JsonObject json4 = new JsonObject();
                json4.addProperty("type_id", type_id);
                int cur_amount = jcontroller.get_cur_amount_type_shelves(json4);
                if(cur_amount == -1){
                    System.out.print("Type not exist\n");
                }
                else{
                    System.out.print(cur_amount);
                    System.out.print("\n");
                }
                print_menu_manager();
            }
            case 5 -> {
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                JsonObject json5 = new JsonObject();
                json5.addProperty("type_id", type_id);
                int cur_amount = jcontroller.get_cur_amount_type_storage(json5);
                if(cur_amount == -1){
                    System.out.print("Type not exist\n");
                }
                else{
                    System.out.print(cur_amount);
                    System.out.print("\n");
                }
                print_menu_manager();
            }
            case 6 -> {
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                JsonObject json6 = new JsonObject();
                json6.addProperty("type_id", type_id);
                float selling_price = jcontroller.get_item_selling_price(json6);
                if(selling_price == -1){
                    System.out.print("Type not exist\n");
                }
                else{
                    System.out.print(selling_price);
                    System.out.print("\n");
                }
                print_menu_manager();
            }
            case 7 -> {
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                JsonObject json7 = new JsonObject();
                json7.addProperty("type_id", type_id);
                float cost_price = jcontroller.get_item_cost_price(json7);
                if(cost_price == -1){
                    System.out.print("Type not exist\n");
                }
                else{
                    System.out.print(cost_price);
                    System.out.print("\n");
                }
                print_menu_manager();
            }
            case 8 -> {
                scanner.nextLine();
                System.out.print("Enter category on report,press enter to include all categories\n");
                String categories = scanner.nextLine();
                System.out.print("Enter sub-category on report,press enter to include all sub-categories\n");
                String sub_categories = scanner.nextLine();
                System.out.print("Enter size on report,press enter to include all sizes\n");
                String sizes = scanner.nextLine();
                JsonObject json8 = new JsonObject();
                json8.addProperty("categories", categories);
                json8.addProperty("sub_categories", sub_categories);
                json8.addProperty("sizes", sizes);
                jcontroller.create_supply_report_Category(json8);
                print_menu_manager();
            }
            case 9 -> {jcontroller.create_faulty_report();print_menu_manager();}
            case 10 -> {
                System.out.print("Enter amount of days to pass?\n");
                int amount_of_days = scanner.nextInt();
                jcontroller.pass_days(amount_of_days);
                print_menu_manager();
            }
            case 11 -> {
                System.out.print("Enter amount of days to the sale\n ");
                int amount_of_days = scanner.nextInt();
                System.out.print("Enter percentage of sale\n");
                user_input = scanner.nextInt();
                System.out.print("Enter type id\n");
                int type_id = scanner.nextInt();
                JsonObject json11 = new JsonObject();
                json11.addProperty("days", amount_of_days);
                json11.addProperty("percentage", user_input);
                json11.addProperty("type_id", type_id);
                jcontroller.set_sale(json11);
                print_menu_manager();
            }
            case 12 -> {
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                System.out.print("Enter the minimal amount \n");
                int minimal_amount = scanner.nextInt();
                JsonObject json12 = new JsonObject();
                json12.addProperty("type_id", type_id);
                json12.addProperty("minimal_amount", minimal_amount);
                jcontroller.set_minimal_amount_type(json12);
                print_menu_manager();
            }
            case 13 -> {
                scanner.nextLine();
                System.out.print("Enter category/categories for sale\n");
                String categories = scanner.nextLine();
                System.out.print("Enter amount of days to the sale\n ");
                int amount_of_days = scanner.nextInt();
                System.out.print("Enter percentage of sale\n");
                int percentage = scanner.nextInt();
                JsonObject json13 = new JsonObject();
                json13.addProperty("days", amount_of_days);
                json13.addProperty("percentage", percentage);
                json13.addProperty("categories", categories);
                jcontroller.set_sale_categories(json13);
                print_menu_manager();
            }
            case 14 -> {
                JsonObject json14 = new JsonObject();
                scanner.nextLine();
                System.out.print("Enter category of the area\n");
                String category = scanner.next();
                json14.addProperty("category",category);
                jcontroller.add_new_area(json14);
                print_menu_manager();
            }
            case 15 -> {
                JsonObject json15 = new JsonObject();
                scanner.nextLine();
                System.out.print("Enter category of the area\n");
                String area_description = scanner.next();
                System.out.print("Enter sub-category of shelf\n");
                String shelf_description = scanner.next();
                json15.addProperty("area_description",area_description);
                json15.addProperty("shelf_description",shelf_description);
                jcontroller.add_shelf_to_area(json15);
                print_menu_manager();
            }
            case 16 ->{
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                JsonObject json16 = new JsonObject();
                json16.addProperty("type_id", type_id);
                jcontroller.get_supplier_sale(json16);
                print_menu_manager();
            }
            case 17 ->{
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                System.out.print("Enter new supplier sale amount \n");
                int new_supplier_sale = scanner.nextInt();
                JsonObject json17 = new JsonObject();
                json17.addProperty("type_id", type_id);
                json17.addProperty("new_supplier_sale", new_supplier_sale);
                jcontroller.set_supplier_sale(json17);
                print_menu_manager();
            }
            case 18 ->{
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                System.out.print("Enter new selling price \n");
                float new_selling_price = scanner.nextFloat();
                JsonObject json18 = new JsonObject();
                json18.addProperty("type_id", type_id);
                json18.addProperty("new_selling_price", new_selling_price);
                jcontroller.set_new_selling_price(json18);
                print_menu_manager();
            }
            case 19 ->{
                System.out.print("Enter item type \n");
                int type_id = scanner.nextInt();
                System.out.print("Enter new cost price \n");
                float new_cost_price = scanner.nextFloat();
                JsonObject json19 = new JsonObject();
                json19.addProperty("type_id", type_id);
                json19.addProperty("new_cost_price", new_cost_price);
                jcontroller.set_new_cost_price(json19);
                print_menu_manager();
            }
            case 20 ->{
                scanner.nextLine();
                System.out.print("Enter category or categories on report,press enter to include all categories\n");
                String categories = scanner.nextLine();
                JsonObject json20 = new JsonObject();
                json20.addProperty("categories", categories);
                jcontroller.create_supply_report(json20);
                print_menu_manager();
            }
            case 21 ->{
                return;
            }
            default -> {
                System.out.print("Invalid input, please try again\n");
                print_menu_manager();
            }
        }
    }


}
