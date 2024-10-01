package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends JFrame {
    private JComboBox<String> dishCategory;
    private JTextField quantityField;
    private JButton addButton;
    private JList<String> orderList;
    private DefaultListModel<String> orderListModel;
    private JTextArea receiptArea;
    private JCheckBox deliveryCheckBox;
    private JRadioButton cashRadioButton;
    private JRadioButton cardRadioButton;
    private JButton saveButton;

    public Restaurant() {
        setTitle("Электронное меню ресторана");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(Restaurant.this,
                        "Вы действительно хотите закрыть приложение?",
                        "Подтверждение закрытия",
                        JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });

        setVisible(true);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JPanel orderPanel = new JPanel(new BorderLayout());
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        JLabel categoryLabel = new JLabel("Выберите категорию:");
        dishCategory = new JComboBox<>(new String[]{"Салаты", "Основные блюда", "Десерты", "Напитки"});

        JLabel quantityLabel = new JLabel("Количество порций:");
        quantityField = new JTextField("1", 5);

        addButton = new JButton("Добавить в заказ");

        orderListModel = new DefaultListModel<>();
        orderList = new JList<>(orderListModel);

        deliveryCheckBox = new JCheckBox("Добавить доставку");

        cashRadioButton = new JRadioButton("Наличные", true);
        cardRadioButton = new JRadioButton("Карта");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashRadioButton);
        paymentGroup.add(cardRadioButton);

        receiptArea = new JTextArea(10, 30);
        receiptArea.setEditable(false);

        saveButton = new JButton("Сохранить заказ");

        inputPanel.add(categoryLabel);
        inputPanel.add(dishCategory);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);

        JButton clearButton = new JButton("Очистить список");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderListModel.clear();
            }
        });

        optionsPanel.add(deliveryCheckBox);
        optionsPanel.add(cashRadioButton);
        optionsPanel.add(cardRadioButton);
        optionsPanel.add(clearButton);

        orderPanel.add(new JLabel("Ваш заказ:"), BorderLayout.NORTH);
        orderPanel.add(new JScrollPane(orderList), BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(orderPanel, BorderLayout.CENTER);
        add(optionsPanel, BorderLayout.WEST);
        add(new JScrollPane(receiptArea), BorderLayout.EAST);
        add(saveButton, BorderLayout.PAGE_END);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category = (String) dishCategory.getSelectedItem();
                String quantity = quantityField.getText();
                orderListModel.addElement(category + " - " + quantity + " порций");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> orderItems = new ArrayList<>();
                for (int i = 0; i < orderListModel.getSize(); i++) {
                    orderItems.add(orderListModel.getElementAt(i));
                }
                boolean isDelivery = deliveryCheckBox.isSelected();
                String paymentMethod = cashRadioButton.isSelected() ? "Наличные" : "Карта";
                generateReceipt(orderItems, isDelivery, paymentMethod);
            }
        });

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generateReceipt(List<String> orderItems, boolean isDelivery, String paymentMethod) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Ваш заказ:\n");
        for (String item : orderItems) {
            receipt.append(item).append("\n");
        }
        if (isDelivery) {
            receipt.append("Доставка включена\n");
        }
        receipt.append("Оплата: ").append(paymentMethod).append("\n");
        receiptArea.setText(receipt.toString());

        try (PrintWriter out = new PrintWriter(new FileWriter("src/main/resources/lab5/order.txt", true))) {
            out.println(receipt);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
