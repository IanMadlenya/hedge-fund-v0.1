package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class ProfileLoginIpRange implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public ProfileLoginIpRange() {}

    /**
     * element : description of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo description__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","description","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean description__is_set = false;

    private java.lang.String description;

    public java.lang.String getDescription() {
      return description;
    }

    public void setDescription(java.lang.String description) {
      this.description = description;
      description__is_set = true;
    }

    /**
     * element : endAddress of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo endAddress__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","endAddress","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean endAddress__is_set = false;

    private java.lang.String endAddress;

    public java.lang.String getEndAddress() {
      return endAddress;
    }

    public void setEndAddress(java.lang.String endAddress) {
      this.endAddress = endAddress;
      endAddress__is_set = true;
    }

    /**
     * element : startAddress of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo startAddress__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","startAddress","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean startAddress__is_set = false;

    private java.lang.String startAddress;

    public java.lang.String getStartAddress() {
      return startAddress;
    }

    public void setStartAddress(java.lang.String startAddress) {
      this.startAddress = startAddress;
      startAddress__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeString(__out, description__typeInfo, description, description__is_set);
       __typeMapper.writeString(__out, endAddress__typeInfo, endAddress, endAddress__is_set);
       __typeMapper.writeString(__out, startAddress__typeInfo, startAddress, startAddress__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        __in.peekTag();
        if (__typeMapper.isElement(__in, description__typeInfo)) {
            setDescription(__typeMapper.readString(__in, description__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, endAddress__typeInfo)) {
            setEndAddress(__typeMapper.readString(__in, endAddress__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, startAddress__typeInfo)) {
            setStartAddress(__typeMapper.readString(__in, startAddress__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[ProfileLoginIpRange ");
      sb.append(" description='").append(com.sforce.ws.util.Verbose.toString(description)).append("'\n");
      sb.append(" endAddress='").append(com.sforce.ws.util.Verbose.toString(endAddress)).append("'\n");
      sb.append(" startAddress='").append(com.sforce.ws.util.Verbose.toString(startAddress)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}