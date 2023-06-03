package CLASS_JAVA;

import javax.swing.*;
import javax.swing.plaf.TableUI;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class SupermarketManagementSystem<Item, ItemTableModel> extends JFrame {

    // Data structures to store items
    private ArrayList<Item> items = new ArrayList<>();

    // GUI components
    private JLabel titleLabel, nameLabel, priceLabel, quantityLabel;
    private JTextField nameTextField, priceTextField, quantityTextField;
    private JButton addButton, removeButton, editButton, clearButton;
    private JTable itemListTable;

    // Table model to display item list
    private ItemTableModel tableModel;

    // Constructor
    public SupermarketManagementSystem(TableModel TableUI) {
        super("Supermarket Management System");

        // Set up GUI components
        titleLabel = new JLabel("Supermarket Management System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        nameLabel = new JLabel("Name:");
        priceLabel = new JLabel("Price:");
        quantityLabel = new JLabel("Quantity:");
        nameTextField = new JTextField(20);
        priceTextField = new JTextField(10);
        quantityTextField = new JTextField(5);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        editButton = new JButton("Edit");
        clearButton = new JButton("Clear");
        tableModel = new ItemTableModel(tableModel);
        itemListTable = new JTable(TableUI);

        // Set up the table columns
        itemListTable.getColumnModel().getColumn(0).setHeaderValue("Name");
        itemListTable.getColumnModel().getColumn(1).setHeaderValue("Price");
        itemListTable.getColumnModel().getColumn(2).setHeaderValue("Quantity");

        // Set up the  layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceTextField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityTextField);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(clearButton);

        JScrollPane itemListScrollPane = new JScrollPane(itemListTable);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(itemListScrollPane, BorderLayout.CENTER);

        // Add components to frame.
        setContentPane(mainPanel);
        add(titleLabel, BorderLayout.NORTH);

        // Set up the event listeners.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editItem();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Set up frame
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected void removeItem() {
    }

    protected void editItem() {
    }

    protected void clearFields() {
    }

    // Method to add item to list
    private void addItem() {
        // Get input data
        String name = nameTextField.getText();
        double price = 0;
        int quantity = 0;
        try {
            price = Double.parseDouble(priceTextField.getText());
            quantity = Integer.parseInt(quantityTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }    

}
