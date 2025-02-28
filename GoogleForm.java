import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class GoogleForm {
    private static final String URL = "jdbc:mysql://localhost:3306/TicketDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Chris@2005";
    private static String email = ""; // Class-level variable to store email
    private static String rate = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("RetroRewind");
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    public static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        Color lightRed = new Color(255, 102, 102);

        JLabel heading = new JLabel();
        heading.setBounds(220, 40, 300, 50);
        String text = "<html><span style='color:red;'>R</span>etro<span style='color:red;'>R</span>ewind</html>";
        heading.setText(text);
        heading.setFont(new Font("Georgia", Font.BOLD, 34));
        panel.add(heading);

        JLabel subhead = new JLabel("About us");
        subhead.setBounds(50, 120, 300, 50);
        subhead.setFont(new Font("Georgia", Font.PLAIN, 22));
        panel.add(subhead);

        JLabel explain = new JLabel();
        String longText = "<html>RetroRewind New Year Party is set to take place on December 31st at 11:00 PM at the beautiful Kovalam Beach in "
                + "Thiruvananthapuram (TVM). This  event gives you a vibrant celebration, bringing together music, dance, and a nostalgic journey "
                + "through retro-themed entertainment.<br>"
                + "Secure your spot now!!!<br></html>";
        explain.setText(longText);
        explain.setBounds(50, 127, 600, 200); // Adjusted size to fit content
        explain.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(explain);

        JButton regnow = new JButton("Book Now");
        regnow.setBounds(50, 380, 150, 30);
        regnow.setBackground(lightRed);
        regnow.setEnabled(false);
        panel.add(regnow);
        regnow.setFocusable(false);

        JButton ret = new JButton("Retrieve Ticket");
        ret.setBounds(370, 380, 150, 30);
        ret.setBackground(lightRed);
        ret.setFocusable(false);
        panel.add(ret);

        regnow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Frame for Registration Form
                JFrame frame3 = new JFrame("Registration Form");
                JPanel panel3 = new JPanel();
                panel3.setBackground(Color.LIGHT_GRAY);

                frame3.setSize(700, 700);
                frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set to DISPOSE_ON_CLOSE
                frame3.add(panel3);
                placeComponentsRegistration(panel3);
                frame3.setVisible(true);
            }
        });

        JButton showdel = new JButton("Meet Our Performer");
        showdel.setBounds(210, 380, 150, 30);
        showdel.setBackground(lightRed);
        panel.add(showdel);
        showdel.setFocusable(false);

        showdel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new JFrame("Our Performer");
                JPanel panel4 = new JPanel();
                panel4.setBackground(Color.LIGHT_GRAY);
                panel4.setLayout(null); // Use null layout to manage bounds manually

                frame4.setSize(500, 500);
                frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame4.add(panel4);
                frame4.setVisible(true);

                // Add Image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\CHRISMON\\Pictures\\images.jpg"); // Change the path to your image
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setBounds(40, 50, 400, 200); // Adjust bounds as needed
                panel4.add(imageLabel);

                // Add Text
                JLabel textLabel = new JLabel("<html>A Rock band with a soundscape built upon elements of folk and classical sounds of India interspersed, <br>"
                        + "at times, with layers of progressive, pop, ambient and electronic textures.</html>");
                textLabel.setBounds(50, 280, 400, 100); // Adjust bounds as needed
                textLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                panel4.add(textLabel);

                JLabel band = new JLabel("Thaikkudam Bridge");
                band.setBounds(120, 160, 400, 200);
                band.setForeground(Color.DARK_GRAY);
                band.setFont(new Font("Georgia", Font.BOLD, 24));
                panel4.add(band);
            }
        });

        JCheckBox termsCheckBox = new JCheckBox("I agree to terms and conditions");
        termsCheckBox.setBounds(50, 340, 220, 30);
        termsCheckBox.setFocusable(false);
        termsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean isSelected = (e.getStateChange() == ItemEvent.SELECTED);
                regnow.setEnabled(isSelected);
            }
        });
        panel.add(termsCheckBox);

        JButton tc = new JButton("View T&C");
        tc.setBounds(50, 300, 100, 30);
        tc.setFocusable(false);
        panel.add(tc);

        tc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Terms & Conditions");
                JPanel panel2 = new JPanel();
                panel2.setBackground(Color.LIGHT_GRAY);
                panel2.setLayout(null); // Use null layout to manage bounds manually

                frame2.setSize(500, 500);
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame2.add(panel2);
                frame2.setVisible(true);

                JLabel heading2 = new JLabel("Terms & Conditions");
                heading2.setBounds(50, 20, 400, 50);
                heading2.setFont(new Font("Georgia", Font.PLAIN, 25));
                panel2.add(heading2);

                String longText = "<html>--> Guests must be 18 years or older to attend.<br><br>"
                        + "--> Any form of harassment, discrimination, or inappropriate behavior will not be tolerated.<br><br>"
                        + "--> Alcohol will be served to guests over the age of 21. Drink responsibly.<br><br>"
                        + "--> Smoking is only permitted in designated areas. Please dispose of cigarette butts responsibly.<br><br>"
                        + "--> In case of an emergency, follow the instructions of the event staff.<br><br>"
                        + "--> Any damages caused by guests will be charged to them accordingly.<br><br>"
                        + "--> The party will end at 1 AM. Please arrange transportation accordingly.<br><br>"
                        + "--> When leaving, please respect the neighborhood and keep noise to a minimum.<br><br></html>";

                JLabel explain2 = new JLabel(longText);
                explain2.setFont(new Font("Arial", Font.PLAIN, 15));

                JScrollPane scrollPane = new JScrollPane(explain2);
                scrollPane.setBounds(50, 80, 400, 350); // Adjust bounds to fit content
                panel2.add(scrollPane);
            }
        });

        ret.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new window to enter phone number
                JFrame rFrame = new JFrame("Retrieve Ticket");
                JPanel rPanel = new JPanel();
                rPanel.setBackground(Color.LIGHT_GRAY);
                rPanel.setLayout(null);

                rFrame.setSize(400, 200);
                rFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                rFrame.add(rPanel);
                rFrame.setVisible(true);

                JLabel phoneLabel = new JLabel("Enter Phone Number:");
                phoneLabel.setBounds(50, 30, 200, 30);
                phoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
                rPanel.add(phoneLabel);

                JTextField phoneField = new JTextField();
                phoneField.setBounds(50, 70, 250, 30);
                rPanel.add(phoneField);

                JButton rButton = new JButton("Retrieve");
                rButton.setBounds(150, 120, 100, 30);
                rButton.setBackground(lightRed);
                rButton.setFocusable(false);
                rPanel.add(rButton);

                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String phone = phoneField.getText();
                        if (phone.isEmpty()) {
                            JOptionPane.showMessageDialog(rPanel, "Please enter your phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Fetch ticket details using phone number
                        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                             PreparedStatement statement = connection.prepareStatement(
                                     "SELECT * FROM Registrations WHERE phone = ?")) {

                            statement.setString(1, phone);
                            ResultSet resultSet = statement.executeQuery();

                            if (resultSet.next()) {
                                // Display ticket details
                                printTicketDetails(resultSet);
                            } else {
                                JOptionPane.showMessageDialog(rPanel, "No ticket found for the provided phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(rPanel, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });
    }

    // Separate method for Registration form components
    public static void placeComponentsRegistration(JPanel panel3) {
        Color lightRed = new Color(255, 102, 102);
        panel3.setLayout(null);

        // Label Title
        JLabel Title = new JLabel("RetroRewind");
        Title.setBounds(200, 20, 400, 50); // Adjusted position and size
        String text = "<html><span style='color:red;'>R</span>etro<span style='color:red;'>R</span>ewind</html>";
        Title.setText(text);
        Title.setFont(new Font("Georgia", Font.BOLD, 34));
        panel3.add(Title);

        JSeparator separator = new JSeparator();
        separator.setBounds(50, 80, 600, 10); // Added separator
        panel3.add(separator);

        // Label for Name
        JLabel name = new JLabel("Name");
        name.setBounds(170, 100, 200, 30);
        name.setFont(new Font("Arial", Font.BOLD, 16));
        panel3.add(name);

        JTextField namebox = new JTextField();
        namebox.setBounds(170, 130, 300, 30);
        namebox.setToolTipText("Enter your full name"); // Added tooltip
        panel3.add(namebox);

        // Label for Age
        JLabel age = new JLabel("Age");
        age.setBounds(170, 170, 200, 30);
        age.setFont(new Font("Arial", Font.BOLD, 16));
        panel3.add(age);

        JTextField agebox = new JTextField();
        agebox.setBounds(170, 200, 300, 30);
        agebox.setToolTipText("Enter your age");
        panel3.add(agebox);

        // Label for Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(170, 240, 200, 30);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel3.add(emailLabel);

        JTextField emailbox = new JTextField();
        emailbox.setBounds(170, 270, 300, 30);
        emailbox.setToolTipText("Enter your email address");
        panel3.add(emailbox);

        // Label for Phone_no
        JLabel phone = new JLabel("Phone");
        phone.setBounds(170, 310, 200, 30);
        phone.setFont(new Font("Arial", Font.BOLD, 16));
        panel3.add(phone);

        JTextField phonebox = new JTextField();
        phonebox.setBounds(170, 340, 300, 30);
        phonebox.setToolTipText("Enter your phone number");
        panel3.add(phonebox);

        // Label for Address
        JLabel address = new JLabel("Address");
        address.setBounds(170, 380, 200, 30);
        address.setFont(new Font("Arial", Font.BOLD, 16));
        panel3.add(address);

        JTextField addressbox = new JTextField();
        addressbox.setBounds(170, 410, 300, 30);
        addressbox.setToolTipText("Enter your address");
        panel3.add(addressbox);

        // ComboBox for No. of Tickets
        JLabel ppl = new JLabel("No. of Participants");
        ppl.setBounds(170, 450, 200, 30);
        ppl.setFont(new Font("Arial", Font.BOLD, 16));
        panel3.add(ppl);

        String[] people = {"1", "2", "3", "4", "5"};
        JComboBox<String> tickets = new JComboBox<>(people);
        tickets.setBounds(170, 480, 300, 30);
        tickets.setFont(new Font("Arial", Font.BOLD, 16));
        tickets.setToolTipText("Select the number of participants");
        panel3.add(tickets);

        String[] price = {"999", "1899", "2799", "3699", "4599"};
        JLabel total = new JLabel("Total Amount: " + price[0]);
        total.setBounds(170, 520, 300, 30);
        total.setFont(new Font("Arial", Font.BOLD, 16));
        panel3.add(total);

        tickets.addActionListener(c -> {
            int index = tickets.getSelectedIndex();
            rate = price[index];
            total.setText("Total Amount: " + rate);
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(170, 560, 300, 30);
        submitButton.setBackground(lightRed);
        submitButton.setFocusable(false);
        submitButton.setToolTipText("Submit your registration");
        panel3.add(submitButton);

        JButton payment = new JButton("Proceed To Payment Window");
        payment.setBounds(170, 600, 300, 30);
        payment.setEnabled(false);
        payment.setBackground(lightRed);
        payment.setFocusable(false);
        payment.setToolTipText("Proceed to payment window after registration");
        panel3.add(payment);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                payment.setEnabled(true);
                String name = namebox.getText();
                String ageText = agebox.getText();
                email = emailbox.getText(); // Store email in class-level variable
                String phone = phonebox.getText();
                String address = addressbox.getText();
                String participants = (String) tickets.getSelectedItem();

                if (name.isEmpty() || ageText.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || participants == null) {
                    JOptionPane.showMessageDialog(panel3, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int age = Integer.parseInt(ageText);
                    if (age < 18) {
                        JOptionPane.showMessageDialog(panel3, "Invalid Age: You must be 18 years or older to book tickets.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel3, "Invalid Age: Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Database insertion logic
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                     PreparedStatement statement = connection.prepareStatement(
                             "INSERT INTO Registrations (name, age, email, phone, address, participants) VALUES (?, ?, ?, ?, ?, ?)")) {

                    statement.setString(1, name);
                    statement.setInt(2, Integer.parseInt(ageText));
                    statement.setString(3, email);
                    statement.setString(4, phone);
                    statement.setString(5, address);
                    statement.setInt(6, Integer.parseInt(participants));

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(panel3, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panel3, "Error: No data inserted.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel3, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        payment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame5 = new JFrame("Payment Window");
                JPanel panel5 = new JPanel();
                panel5.setBackground(Color.LIGHT_GRAY);
                panel5.setLayout(null); // Use null layout to manage bounds manually

                frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame5.setSize(700, 700);
                frame5.add(panel5);
                placeComponentsPayment(panel5);
                frame5.setVisible(true);
            }
        });
    }

    public static void placeComponentsPayment(JPanel panel5) {
        panel5.setLayout(null);
        panel5.setBackground(Color.LIGHT_GRAY);

        JLabel head = new JLabel("Payment Gateway");
        head.setBounds(150, 30, 400, 50); // Adjusted position and size
        head.setFont(new Font("Georgia", Font.BOLD, 28));
        panel5.add(head);

        JSeparator separator = new JSeparator();
        separator.setBounds(50, 90, 600, 10);
        panel5.add(separator);

        JLabel methodLabel = new JLabel("Select Payment Method:");
        methodLabel.setBounds(150, 120, 200, 30);
        methodLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel5.add(methodLabel);

        String[] paymtds = {"Net Banking", "Credit/Debit Card", "UPI"};
        JComboBox<String> paymeth = new JComboBox<>(paymtds);
        paymeth.setBounds(350, 120, 200, 30);
        paymeth.setFont(new Font("Arial", Font.BOLD, 16));
        panel5.add(paymeth);

        JLabel paybox = new JLabel("Account No:");
        paybox.setBounds(150, 170, 200, 30);
        paybox.setFont(new Font("Arial", Font.BOLD, 16));
        panel5.add(paybox);

        JTextField info = new JTextField();
        info.setBounds(350, 170, 200, 30);
        panel5.add(info);

        paymeth.addActionListener(d -> {
            String[] method = {"Account No:", "Card No:", "UPI ID:"};
            int ind = paymeth.getSelectedIndex();
            paybox.setText(method[ind]);
        });

        JLabel amountLabel = new JLabel("Total Amount to Pay:");
        amountLabel.setBounds(150, 220, 200, 30);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel5.add(amountLabel);

        JLabel amountValue = new JLabel("₹ " + rate); // Set the actual amount
        amountValue.setBounds(350, 220, 200, 30);
        amountValue.setFont(new Font("Arial", Font.BOLD, 16));
        panel5.add(amountValue);

        JButton Proceed = new JButton("Proceed");
        Proceed.setBounds(250, 280, 200, 40);
        Proceed.setFont(new Font("Arial", Font.BOLD, 16));
        Proceed.setFocusable(false);
        Proceed.setBackground(new Color(0, 123, 255));
        Proceed.setForeground(Color.WHITE);
        panel5.add(Proceed);

        Proceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paymentMethod = (String) paymeth.getSelectedItem();
                String paymentDetails = info.getText();

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                     PreparedStatement statement = connection.prepareStatement(
                             "UPDATE Registrations SET payment_method = ?, payment_status = ? WHERE email = ?")) {

                    statement.setString(1, paymentMethod);
                    statement.setString(2, "Completed");
                    statement.setString(3, email); // Use email to identify the user

                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(panel5, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        printTicketDetails(email);
                    } else {
                        JOptionPane.showMessageDialog(panel5, "Error: No matching registration found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel5, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void printTicketDetails(ResultSet resultSet) throws SQLException {
        // Create a new frame to display ticket details
        JFrame ticketFrame = new JFrame("Ticket Details");
        JPanel ticketPanel = new JPanel();
        ticketPanel.setBackground(Color.DARK_GRAY);
        ticketPanel.setLayout(null);

        ticketFrame.setSize(500, 500);
        ticketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticketFrame.add(ticketPanel);
        ticketFrame.setVisible(true);

        // Add ticket details to the panel
        JLabel heading = new JLabel("Ticket Details");
        heading.setBounds(150, 20, 200, 30);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Georgia", Font.BOLD, 24));
        ticketPanel.add(heading);

        JLabel nameLabel = new JLabel("Name: " + resultSet.getString("name"));
        nameLabel.setBounds(50, 70, 400, 30);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setForeground(Color.WHITE);
        ticketPanel.add(nameLabel);

        JLabel ageLabel = new JLabel("Age: " + resultSet.getInt("age"));
        ageLabel.setBounds(50, 110, 400, 30);
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ageLabel.setForeground(Color.WHITE);
        ticketPanel.add(ageLabel);

        JLabel emailLabel = new JLabel("Email: " + resultSet.getString("email"));
        emailLabel.setBounds(50, 150, 400, 30);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setForeground(Color.WHITE);
        ticketPanel.add(emailLabel);

        JLabel phoneLabel = new JLabel("Phone: " + resultSet.getString("phone"));
        phoneLabel.setBounds(50, 190, 400, 30);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneLabel.setForeground(Color.WHITE);
        ticketPanel.add(phoneLabel);

        JLabel addressLabel = new JLabel("Address: " + resultSet.getString("address"));
        addressLabel.setBounds(50, 230, 400, 30);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        addressLabel.setForeground(Color.WHITE);
        ticketPanel.add(addressLabel);

        JLabel participantsLabel = new JLabel("Participants: " + resultSet.getInt("participants"));
        participantsLabel.setBounds(50, 270, 400, 30);
        participantsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        participantsLabel.setForeground(Color.WHITE);
        ticketPanel.add(participantsLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(50, 320, 400, 10);
        ticketPanel.add(separator);

        JLabel note = new JLabel("Take screenshot for party-entry");
        note.setBounds(120, 340, 300, 30); // Adjusted position and size
        note.setFont(new Font("Arial", Font.BOLD, 16));
        note.setForeground(Color.YELLOW);
        ticketPanel.add(note);
    }
    public static void printTicketDetails(String email) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM Registrations WHERE email = ?")) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Create a new frame to display ticket details
                JFrame ticketFrame = new JFrame("Ticket Details");
                JPanel ticketPanel = new JPanel();
                ticketPanel.setBackground(Color.DARK_GRAY);
                ticketPanel.setLayout(null);

                ticketFrame.setSize(500, 500);
                ticketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ticketFrame.add(ticketPanel);
                ticketFrame.setVisible(true);

                // Add ticket details to the panel
                JLabel heading = new JLabel("Ticket Details");
                heading.setBounds(150, 20, 200, 30);
                heading.setForeground(Color.RED);
                heading.setFont(new Font("Georgia", Font.BOLD, 24));
                ticketPanel.add(heading);

                JLabel nameLabel = new JLabel("Name: " + resultSet.getString("name"));
                nameLabel.setBounds(50, 70, 400, 30);
                nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                nameLabel.setForeground(Color.WHITE);
                ticketPanel.add(nameLabel);

                JLabel ageLabel = new JLabel("Age: " + resultSet.getInt("age"));
                ageLabel.setBounds(50, 110, 400, 30);
                ageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                ageLabel.setForeground(Color.WHITE);
                ticketPanel.add(ageLabel);

                JLabel emailLabel = new JLabel("Email: " + resultSet.getString("email"));
                emailLabel.setBounds(50, 150, 400, 30);
                emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                emailLabel.setForeground(Color.WHITE);
                ticketPanel.add(emailLabel);

                JLabel phoneLabel = new JLabel("Phone: " + resultSet.getString("phone"));
                phoneLabel.setBounds(50, 190, 400, 30);
                phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                phoneLabel.setForeground(Color.WHITE);
                ticketPanel.add(phoneLabel);

                JLabel addressLabel = new JLabel("Address: " + resultSet.getString("address"));
                addressLabel.setBounds(50, 230, 400, 30);
                addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                addressLabel.setForeground(Color.WHITE);
                ticketPanel.add(addressLabel);

                JLabel participantsLabel = new JLabel("Participants: " + resultSet.getInt("participants"));
                participantsLabel.setBounds(50, 270, 400, 30);
                participantsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                participantsLabel.setForeground(Color.WHITE);
                ticketPanel.add(participantsLabel);

                JSeparator separator = new JSeparator();
                separator.setBounds(50, 320, 400, 10);
                ticketPanel.add(separator);

                JLabel note = new JLabel("Take screenshot for party-entry");
                note.setBounds(120, 340, 300, 30); // Adjusted position and size
                note.setFont(new Font("Arial", Font.BOLD, 16));
                note.setForeground(Color.YELLOW);
                ticketPanel.add(note);
            } else {
                JOptionPane.showMessageDialog(null, "No ticket details found for the provided email.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
