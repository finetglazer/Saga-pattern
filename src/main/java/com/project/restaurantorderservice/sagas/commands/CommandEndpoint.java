// File: src/main/java/com/project/restaurantorderservice/sagas/commands/CommandEndpoint.java
package com.project.restaurantorderservice.sagas.commands;

/**
 * A simplified implementation of CommandEndpoint to resolve dependency issues
 */
public class CommandEndpoint<C> {
    private Class<C> commandClass;
    private String channel;
    private Class<?> replyClass;

    private CommandEndpoint(Class<C> commandClass, String channel, Class<?> replyClass) {
        this.commandClass = commandClass;
        this.channel = channel;
        this.replyClass = replyClass;
    }

    public static <C> Builder<C> builder() {
        return new Builder<>();
    }

    public static class Builder<C> {
        private Class<C> commandClass;
        private String channel;
        private Class<?> replyClass;

        public Builder<C> forCommand(Class<C> commandClass) {
            this.commandClass = commandClass;
            return this;
        }

        public Builder<C> withChannel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder<C> withReply(Class<?> replyClass) {
            this.replyClass = replyClass;
            return this;
        }

        public CommandEndpoint<C> build() {
            return new CommandEndpoint<>(commandClass, channel, replyClass);
        }
    }

    // Getters
    public Class<C> getCommandClass() {
        return commandClass;
    }

    public String getChannel() {
        return channel;
    }

    public Class<?> getReplyClass() {
        return replyClass;
    }
}