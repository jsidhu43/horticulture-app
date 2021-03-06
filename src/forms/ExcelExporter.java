package forms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;


	
	public class ExcelExporter {

	    void fillData(JTable table, File file) {

	    	try{
	            TableModel model = table.getModel();
	            FileWriter excel = new FileWriter(file);

	            for(int i = 0; i < model.getColumnCount(); i++){
	                excel.write(model.getColumnName(i) + "\t");
	            }

	            excel.write("\n");

	            for(int i=0; i< model.getRowCount(); i++) {
	                for(int j=0; j < model.getColumnCount(); j++) {
	                    excel.write(model.getValueAt(i,j).toString()+"\t");
	                }
	                excel.write("\n");
	            }

	            excel.close();

	        }catch(IOException e){ System.out.println(e); }
	    }

	//Read more: http://niravjavadeveloper.blogspot.com/2011/05/java-swing-export-jtable-to-excel-file.html#ixzz4BqbNnW9S

	    public static void main(String[] args) {
	    	new ExcelExporter();	
	    }
	    }

