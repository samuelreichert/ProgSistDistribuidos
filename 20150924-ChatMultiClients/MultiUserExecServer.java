package br.feevale;

/**
 * Created by samuel on 24/09/15.
 */
public class MultiUserExecServer {
    public static void main(String[] args) {
        MultiUserChatServer mucs = new MultiUserChatServer();
        mucs.configServer();
        mucs.waitClients();
    }
}
