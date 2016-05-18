/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlencription;

import javax.crypto.SecretKey;
import org.apache.xml.security.encryption.XMLCipher;
import org.w3c.dom.Document;

/**
 *
 * @author Oriol
 */
public class Main {

    public static void main(String args[]) throws Exception {
        String xmlFile = "xml/didlFilm1.xml";
        String encryptedFile = "xml/encrypted.xml";
        String decryptedFile = "xml/decrypted.xml";

        SecretKey secretKey = SecretKeyUtil.getSecretKey("AES");
        Document document = XMLUtil.getDocument(xmlFile);

        Document encryptedDoc = XMLUtil.encryptDocument(document, secretKey,
                XMLCipher.AES_128);
        XMLUtil.saveDocumentTo(encryptedDoc, encryptedFile);

        Document decryptedDoc = XMLUtil.decryptDocument(encryptedDoc,
                secretKey, XMLCipher.AES_128);
        XMLUtil.saveDocumentTo(decryptedDoc, decryptedFile);

        System.out.println("Done");
    }

}
