package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateAccountTypeAggregate {

    @AggregateIdentifier
    private String accountTypeId;

    private String accountName;

    private String description;

    private double price;

    @CommandHandler
    public CreateAccountTypeAggregate(CreateAccountTypeCommand command){
        AccountTypeCreatedEvent accountTypeCreatedEvent = new AccountTypeCreatedEvent();

        BeanUtils.copyProperties(command,accountTypeCreatedEvent);

        AggregateLifecycle.apply(accountTypeCreatedEvent);//lifecycle event sourcing handlera ve evet handlera bakar
    }

    @EventSourcingHandler //service busa gönderilecek değerler // servicebus örnekleri -> kafka, rabbitmq, azureServicebus
    public void on(AccountTypeCreatedEvent accountTypeCreatedEvent){
        this.accountTypeId = accountTypeCreatedEvent.getAccountTypeId();
        this.accountName = accountTypeCreatedEvent.getAccountName();
        this.description = accountTypeCreatedEvent.getDescription();
        this.price = accountTypeCreatedEvent.getPrice();
    }
}
