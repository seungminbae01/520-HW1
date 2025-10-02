import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      if (!InputValidation.isValidAmount(view.getAmountField())) {
          JOptionPane.showMessageDialog(view, "Amount must be a number > 0 and < 1000.");
          return;
      }
      if (!InputValidation.isValidCategory(view.getCategoryField())) {
          JOptionPane.showMessageDialog(view, "Category must be: food, travel, bills, entertainment, or other.");
          return;
      }

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });

  }

}