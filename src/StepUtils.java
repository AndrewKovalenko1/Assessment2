import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StepUtils {

    public static void manipulateSteps(List<Step> steps, Scanner scanner, Recipe recipe) {
        boolean isContinued = true;
        String menu = """
                  Manipulates with sreps menu
                  Choose an option:
                  1 - Create and add new step
                  2 - Show all steps
                  3 - Edit step by number
                  4 - Delete step by number
                  m - Show menu
                  any key - exit from menu
                \s""";
        System.out.print(menu);
        do {
            System.out.print("\nChoose option from Manipulate with steps menu: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createEditStep(steps, scanner, null);
                    break;
                case "2":
                    System.out.println("Steps of " + recipe.getName() + ":");
                    for(Step step : steps) {
                        System.out.println(step);
                    }
                    break;
                case "3":
                    Step step = searchStepByNumber(steps, scanner);
                    if(step != null) {
                        System.out.println("Now you can edit step: " + step);
                        createEditStep(steps, scanner, step);
                    } else {
                        System.out.println("Step not found!");
                    }
                    break;
                case "4":
                    deleteStep(steps, scanner);
                    break;
                case "m":
                    System.out.println(menu);
                    break;
                default:
                    isContinued = false;
                    break;
            }
        } while (isContinued);
    }


    public static void createEditStep(List<Step> stepList, Scanner scanner, Step step) {

        boolean isCreation = false;
        boolean isCompleted  = false;
        boolean isCanceled = false;
        if (step == null) {
            step = new Step();
            isCreation = true;
        }
        System.out.println("Here you can " + (isCreation ? "create new" : "edit") + " step.");

        String menu = """
                  Here you can create new or edit step.
                  You have to fill next fields. Type a number from menu to fill a field:
                  1 - Enter a step number
                  2 - Enter a instruction
                  m - Show menu
                  s - Save step
                  c - Cancel step creation
                \s""";
        System.out.print(menu);

        do {
            System.out.print("\nChoose a punkt from Create-Edit step menu: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    step.setStepNumber(CommonMethods.createEditIntField(step.getStepNumber(), "Step number", scanner));
                    break;
                case "2":
                    step.setInstruction(CommonMethods.createEditStringField(step.getInstruction(), "Instruction", scanner));
                    break;
                case "m":
                    System.out.println(menu);
                    break;
                case "s":
                    if (saveStepIfValid(step, stepList, isCreation)) {
                        isCompleted = true;
                        if (isCreation)  {
                            System.out.println("Step "+ step +" has been created.");
                        } else {
                            System.out.println("Step "+ step +" has been edited.");
                        }
                    }
                    break;
                case "c":
                    System.out.println("You canceled this step"+ (isCreation ? "creation!" : "editing!"));
                    isCanceled = true;
                    break;
                default:
                    System.out.println("There no such command in creation menu. Press 'm' to show menu");
                    break;
            }
        } while (!isCompleted && !isCanceled);

    }

    private static Step searchStepByNumber(List<Step> steps, Scanner scanner) {
        int number = CommonMethods.enterPositiveIntNumber(scanner, "Please enter the number of step you want to search: ");
        Optional<Step> step = steps.stream().filter(t -> t.getStepNumber() == number).findFirst();

        if (step.isPresent()) {
            System.out.println("The step has been found!");
            return step.get();
        } else {
            System.out.println("The step could not be found!");
            return null;
        }
    }

    private static boolean saveStepIfValid(Step step, List<Step> stepList, boolean isCreation) {

        if (step.getStepNumber() == 0 ) {
            System.out.println("Step number is required. Please enter the step number.");
            return false;
        }
        if (step.getInstruction() == null || step.getInstruction().isBlank()) {
            System.out.println("Instruction for step is required. Please enter the instruction.");
            return false;
        }

        if (isCreation) {
            stepList.add(step);
        }

        System.out.println("Ingredient was saved successfully: " + step);
        return true;

    }

    private static void deleteStep(List<Step> stepList, Scanner scanner) {

        Step step = searchStepByNumber(stepList, scanner);
        if (step == null) {
            return;
        }

        if (stepList.remove(step)) {
            System.out.println("Step removed successfully!");
        }

    }
}
