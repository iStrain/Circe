/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CRC;

/**
 *
 * @author Ian
 */


import java.awt.Font;
import java.lang.String;

public class crc_gui extends javax.swing.JFrame {

   public problem_data Problem_data = new problem_data();
   public Base2_Solver B2_Solver = new Base2_Solver();
   public ShiftedPoly_Solver SP_Solver = new ShiftedPoly_Solver();

   /** Creates new form crc_gui */
   public crc_gui() {
       super("CRC Trainer");
      initComponents();

      //initialise data for problem.
      this.update_problem_display();
      B2_Solver.solve_base2(Problem_data, Base2_table);
      SP_Solver.Solve_ShiftedPoly(Base2_table, SP_table);

      this.setVisible(true);
   }

   private void update_problem_display() {
      int field_pos;
      int string_output_len;
      String string_output;

      // create a new set of binary numbers for a new problem.
      Problem_data.Gen_New_Prob();


      // convert data binary numb to string and display
      string_output_len = Problem_data.getData_len();
      string_output = "";
      for (field_pos = 0; field_pos < string_output_len; field_pos++) {
         if (Problem_data.getData().bits.get(field_pos)) {
            string_output = string_output + "1";
         } else {
            string_output = string_output + "0";
         }
      }
      //display string
      fld_Data.setText(string_output);

      // convert pattern binary numb to string and display
      string_output_len = Problem_data.getPattern_len();
      string_output = "";
      for (field_pos = 0; field_pos < string_output_len; field_pos++) {
         if (Problem_data.getPattern().bits.get(field_pos)) {
            string_output = string_output + "1";
         } else {
            string_output = string_output + "0";
         }
      }
      //display string
      fld_Pattern.setText(string_output);

      B2_Solver.solve_base2(Problem_data, Base2_table);
      SP_Solver.Solve_ShiftedPoly(Base2_table, SP_table);
   }
   

      
         private void initComponents()
                 {

      Tabs = new javax.swing.JTabbedPane();
      Instructions = new javax.swing.JPanel();
      jScrollPane2 = new javax.swing.JScrollPane();
      jTextArea1 = new javax.swing.JTextArea();
      New_Prob_btn = new javax.swing.JButton();
      fld_Data = new javax.swing.JTextField();
      lbl_Data = new javax.swing.JLabel();
      lbl_Pattern = new javax.swing.JLabel();
      fld_Pattern = new javax.swing.JTextField();
      Base2 = new javax.swing.JPanel();
      Base2_table = new javax.swing.JTable();
      ShiftedPoly = new javax.swing.JPanel();
      jScrollPane4 = new javax.swing.JScrollPane();
      SP_table = new javax.swing.JTable();
      SP_table.setFont(new Font("Serif", Font.PLAIN , 18));

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jTextArea1.setColumns(20);
      jTextArea1.setLineWrap(true);
      jTextArea1.setRows(5);
      jTextArea1.setText("\nInstructions\n\n1. Press the button below to get a new CRC Problem.\n\n2. Attempt the problem yourself.\n\n3. Compare your answers to those in the Base2 and Shifted Poly tabs.\n\n"); // NOI18N
      jTextArea1.setWrapStyleWord(true);
      jScrollPane2.setViewportView(jTextArea1);

      New_Prob_btn.setText("New CRC Problem"); // NOI18N
      New_Prob_btn.setToolTipText("Press this button to generate new Data and Pattern strings");
      New_Prob_btn.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            New_Prob_btnActionPerformed(evt);
         }
      });

      fld_Data.setEditable(false);
      fld_Data.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

      lbl_Data.setText("Data"); // NOI18N

      lbl_Pattern.setText("Pattern"); // NOI18N

      fld_Pattern.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
      fld_Pattern.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            fld_PatternActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout InstructionsLayout = new org.jdesktop.layout.GroupLayout(Instructions);
      Instructions.setLayout(InstructionsLayout);
      InstructionsLayout.setHorizontalGroup(
         InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(InstructionsLayout.createSequentialGroup()
            .addContainerGap()
            .add(InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 464, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(InstructionsLayout.createSequentialGroup()
                  .add(New_Prob_btn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(65, 65, 65)
                  .add(InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                     .add(lbl_Data)
                     .add(lbl_Pattern))
                  .add(23, 23, 23)
                  .add(InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                     .add(fld_Pattern)
                     .add(fld_Data, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(126, Short.MAX_VALUE))
      );
      InstructionsLayout.setVerticalGroup(
         InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(InstructionsLayout.createSequentialGroup()
            .addContainerGap()
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(24, 24, 24)
            .add(InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(New_Prob_btn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(InstructionsLayout.createSequentialGroup()
                  .add(InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                     .add(lbl_Data)
                     .add(fld_Data, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(InstructionsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                     .add(lbl_Pattern)
                     .add(fld_Pattern, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(73, Short.MAX_VALUE))
      );

      Tabs.addTab("Instructions", Instructions);

      Base2_table.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][]
         {
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
         },
         new String []
         {
            "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23", "Title 24", "Title 25"
         }
      ));
      Base2_table.setGridColor(java.awt.Color.lightGray);
      Base2_table.setIntercellSpacing(new java.awt.Dimension(5, 5));
      Base2_table.setShowVerticalLines(false);

      org.jdesktop.layout.GroupLayout Base2Layout = new org.jdesktop.layout.GroupLayout(Base2);
      Base2.setLayout(Base2Layout);
      Base2Layout.setHorizontalGroup(
         Base2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(Base2_table, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
      );
      Base2Layout.setVerticalGroup(
         Base2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(Base2_table, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
      );

      Tabs.addTab("Base2 Solution", Base2);

      SP_table.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][]
         {
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null},
            {null}
         },
         new String []
         {
            "Title 1"
         }
      ));
      jScrollPane4.setViewportView(SP_table);

      org.jdesktop.layout.GroupLayout ShiftedPolyLayout = new org.jdesktop.layout.GroupLayout(ShiftedPoly);
      ShiftedPoly.setLayout(ShiftedPolyLayout);
      ShiftedPolyLayout.setHorizontalGroup(
         ShiftedPolyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(ShiftedPolyLayout.createSequentialGroup()
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 502, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(98, Short.MAX_VALUE))
      );
      ShiftedPolyLayout.setVerticalGroup(
         ShiftedPolyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(ShiftedPolyLayout.createSequentialGroup()
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 313, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(25, Short.MAX_VALUE))
      );

      Tabs.addTab("Shifted Poly Solution", ShiftedPoly);

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(Tabs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 605, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(Tabs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 366, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }
                 
                    private void New_Prob_btnActionPerformed (java.awt.event.ActionEvent evt)                                             
   {                                                 
      // TODO  add your handling code here:
      update_problem_display();
}                                            

   private void fld_PatternActionPerformed (java.awt.event.ActionEvent evt)                                            
   {                                                
   // TODO add your handling code here:
   } 
         
   // Variables declaration - do not modify                     
   public javax.swing.JPanel Base2;
   public javax.swing.JTable Base2_table;
   public javax.swing.JPanel Instructions;
   public javax.swing.JButton New_Prob_btn;
   public javax.swing.JTable SP_table;
   public javax.swing.JPanel ShiftedPoly;
   public javax.swing.JTabbedPane Tabs;
   public javax.swing.JTextField fld_Data;
   public javax.swing.JTextField fld_Pattern;
   public javax.swing.JScrollPane jScrollPane2;
   public javax.swing.JScrollPane jScrollPane4;
   public javax.swing.JTextArea jTextArea1;
   public javax.swing.JLabel lbl_Data;
   public javax.swing.JLabel lbl_Pattern;
   // End of variables declaration                   

       public static void main(String[] arguments){
        crc_gui crc =new crc_gui();
    }
}
