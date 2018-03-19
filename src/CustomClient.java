import com.doszhan.CustomServiceStub;

import java.rmi.RemoteException;

public class CustomClient {

    private final static String END_POINT = "http://localhost:8080/axis2/services/CustomService?wsdl";

    public static void main(String[] args) {

    }
        public void  createStudent(String name,String surname, Integer group, String facultet, Double srbal, String number,String university,String sphere,String spec){
        try {

            CustomServiceStub stub = new CustomServiceStub(END_POINT);
            CustomServiceStub.Student student = new CustomServiceStub.Student();
            CustomServiceStub.Facultet facultet1   = new CustomServiceStub.Facultet();
            CustomServiceStub.Univercity univercity = new CustomServiceStub.Univercity();
            facultet1.setGroup(group);
            facultet1.setNameFacultet(facultet);
            facultet1.setNameSpeciality(spec);
            univercity.setFacultet(facultet1);
            univercity.setName(university);
            univercity.setSphere(sphere);
            student.setUnivercity(univercity);
            student.setName(name);
            student.setSurname(surname);

            student.setSrbal(srbal);
            student.setNumber(number);

            CustomServiceStub.CreateStudent createStudent = new CustomServiceStub.CreateStudent();
            createStudent.setStudent(student);
            stub.createStudent(createStudent);
        }
        catch (RemoteException e1)
        {
            e1.printStackTrace();
        }

    }
    public void  deleteStudent(String name){
        try {
            CustomServiceStub stub = new CustomServiceStub(END_POINT);
            CustomServiceStub.DeleteStudentFromGui deleteStudentFromGui = new CustomServiceStub.DeleteStudentFromGui();
            deleteStudentFromGui.setNamefile(name);
            stub.deleteStudentFromGui(deleteStudentFromGui);
        }
        catch (RemoteException e1)
        {

        }
        //adben to java object
    }
    public String readFile(String filename){
     try {
         CustomServiceStub stub = new CustomServiceStub(END_POINT);
         CustomServiceStub.ReadFile readFile = new CustomServiceStub.ReadFile();
         readFile.setFilenames(filename);
         CustomServiceStub.ReadFileResponse readFileResponse = stub.readFile(readFile);
         String response = readFileResponse.get_return();
         return response;
     }
     catch (RemoteException e){
         return "Eror read";

     }

    }
    public String[] getNameFile(){
        try {
            CustomServiceStub stub = new CustomServiceStub(END_POINT);
            CustomServiceStub.GetFilesName getInfoFromSubsection = new CustomServiceStub.GetFilesName();

            CustomServiceStub.GetFilesNameResponse getInfoFromSubsection1 = stub.getFilesName(getInfoFromSubsection);
            String[] strings = getInfoFromSubsection1.get_return();

            return  strings;



        } catch (RemoteException e) {
            return  new String[]{};

        }

    }
    public String[] getPathFile(){
        try {
            CustomServiceStub stub = new CustomServiceStub(END_POINT);
            CustomServiceStub.GetFilesPath getFilesPath = new CustomServiceStub.GetFilesPath();

            CustomServiceStub.GetFilesPathResponse getFilesPathResponse = stub.getFilesPath(getFilesPath);
            String[] strings = getFilesPathResponse.get_return();

            return  strings;



        } catch (RemoteException e) {
            return new String[]{};
        }


    }









}