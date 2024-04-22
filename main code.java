import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.Rect;
import org.opencv.core.CvType;
import org.opencv.core.MatOfByte;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.CvType;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class EmotionDetector {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_default.xml");
        Mat image = Imgcodecs.imread("path_to_your_image.jpg");
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 2);
        }
        
        Imgcodecs.imwrite("output_image.jpg", image);
    }
}
/*В приведенном выше коде используется каскадный классификатор Haar для обнаружения лиц на изображении. 
Пожалуйста, убедитесь, что у вас установлена библиотека OpenCV для Java и загружен файл haarcascade_frontalface_default.xml, который содержит обученную модель для распознавания лиц. 
Также не забудьте указать путь к вашему изображению и сохраненному изображению.

Обратите внимание, что это всего лишь пример кода для распознавания лиц на изображении с помощью Java и OpenCV. Для анализа эмоций с лицом возможно вам понадобится использовать другие методы для распознавания эмоций, 
такие как нейронные сети или другие глубокие обученные модели. */