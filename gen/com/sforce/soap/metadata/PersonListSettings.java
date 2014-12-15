package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class PersonListSettings extends com.sforce.soap.metadata.Metadata {

    /**
     * Constructor
     */
    public PersonListSettings() {}

    /**
     * element : enablePersonList of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo enablePersonList__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","enablePersonList","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean enablePersonList__is_set = false;

    private boolean enablePersonList;

    public boolean getEnablePersonList() {
      return enablePersonList;
    }

    public boolean isEnablePersonList() {
      return enablePersonList;
    }

    public void setEnablePersonList(boolean enablePersonList) {
      this.enablePersonList = enablePersonList;
      enablePersonList__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "http://soap.sforce.com/2006/04/metadata", "PersonListSettings");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeBoolean(__out, enablePersonList__typeInfo, enablePersonList, enablePersonList__is_set);
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
        super.loadFields(__in, __typeMapper);
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, enablePersonList__typeInfo)) {
            setEnablePersonList(__typeMapper.readBoolean(__in, enablePersonList__typeInfo, boolean.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[PersonListSettings ");
      sb.append(super.toString());sb.append(" enablePersonList='").append(com.sforce.ws.util.Verbose.toString(enablePersonList)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}