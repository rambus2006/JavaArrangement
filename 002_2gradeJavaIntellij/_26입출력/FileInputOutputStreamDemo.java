package _26입출력;

public class FileInputOutputStreamDemo {
    public static void main(String[] args) throws IOException {
    // 생성할 파일 이름 전달
            ByteArrayInputStream, ByteArrayOutputStream
            내부 메모리에 저장된 바이트 배열이 입출력 대상인 입출력 스트림
            FileOutputStream fos = new FileOutputStream("temp" + File.separator + "test.bin");
    // 한 바이트 쓰기 (최소 단위는 바이트)
            fos.write(0x00);
    // 바이트 배열 쓰기
            fos.write(new byte[]{ 0x01, 0x02, 0x03 });
    // 바이트 배열을 쓰되, 쓰기 시작할 배열의 시작 위치 및 크기를 정해주기
            fos.write(new byte[]{ 0x0a, 0x0b, 0x0c, 0x0d, 0x0e }, 1, 3);
    // 입출력 리소스는 반드시 close 메서드로 닫아줄 것
            fos.close();
