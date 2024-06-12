//klasa stworzona na podstawie pliku xsd
//klasa służąca do stworzenia odpowiedzi dla wygenerowania zapytania sql do bazy danych
package pc.psisk.soap_webservice.webservice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="trackName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="trackAlbum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="trackArtist" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="trackGenre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trackName",
    "trackAlbum",
    "trackArtist",
    "trackGenre"
})
@XmlRootElement(name = "sqlResponse", namespace = "http://psiskproj.com/webservice")
public class SqlResponse {

    @XmlElement(required = true)
    protected String trackName;
    @XmlElement(required = true)
    protected String trackAlbum;
    @XmlElement(required = true)
    protected String trackArtist;
    @XmlElement(required = true)
    protected String trackGenre;

    /**
     * Gets the value of the trackName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * Sets the value of the trackName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackName(String value) {
        this.trackName = value;
    }

    /**
     * Gets the value of the trackAlbum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackAlbum() {
        return trackAlbum;
    }

    /**
     * Sets the value of the trackAlbum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackAlbum(String value) {
        this.trackAlbum = value;
    }

    /**
     * Gets the value of the trackArtist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackArtist() {
        return trackArtist;
    }

    /**
     * Sets the value of the trackArtist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackArtist(String value) {
        this.trackArtist = value;
    }

    /**
     * Gets the value of the trackGenre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackGenre() {
        return trackGenre;
    }

    /**
     * Sets the value of the trackGenre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackGenre(String value) {
        this.trackGenre = value;
    }

}
