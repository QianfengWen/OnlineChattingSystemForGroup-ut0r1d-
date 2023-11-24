package chattingSystem.interface_adapter.presenter;


import chattingSystem.entities.ChatRoom.ChatRoom;
import chattingSystem.entities.Message.Message;
import chattingSystem.entities.User.User;
import chattingSystem.frameworks_drivers.ui.views.ChatRoomView;
import chattingSystem.frameworks_drivers.ui.views.ChatRoomViewManager;
import chattingSystem.frameworks_drivers.ui.views.ViewManager;
import chattingSystem.interface_adapter.controllers.LogOutController;
import chattingSystem.interface_adapter.state.ChatRoomState;
import chattingSystem.interface_adapter.state.LoginState;
import chattingSystem.interface_adapter.view_models.ChatRoomViewManagerModel;
import chattingSystem.interface_adapter.view_models.ChatRoomViewModel;
import chattingSystem.interface_adapter.view_models.LoginViewModel;
import chattingSystem.interface_adapter.view_models.ViewManagerModel;
import chattingSystem.use_cases.join_chat_room.JoinChatRoomOutpurBoundary;
import chattingSystem.use_cases.join_chat_room.JoinChatRoomOutputData;
import chattingSystem.use_cases.log_out.LogOutDataAccessBoundary;
import chattingSystem.use_cases.log_out.LogOutOutputBoundary;
import chattingSystem.use_cases.log_out.LogOutOutputData;
import chattingSystem.use_cases.refresh_messages.RefreshMessageOutputData;
import chattingSystem.use_cases.refresh_messages.RefreshMessagesDataAccessBoundary;
import chattingSystem.use_cases.refresh_messages.RefreshMessagesOutputBoundary;
import chattingSystem.use_cases.send_message.SendMessageOutputBoundary;
import chattingSystem.use_cases.send_message.SendMessageUserDataAccessInterface;
import chattingSystem.use_cases.signup.SignupOutputData;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static chattingSystem.App.ChatRoomFrameFactory.createChatRoomFrame;


public class ChatRoomPresenter implements JoinChatRoomOutpurBoundary, LogOutOutputBoundary{
    // the presenter for the chat room, will be used for sending messages
    // and receiving messages
    private ViewManagerModel viewManagerModel;

    public ChatRoomPresenter() {
        // every time we create a new chat room presenter, we create a new chat room view model, so that different User could use the chat room
        this.viewManagerModel = new ViewManagerModel();
    }


    @Override
    public void prepareSuccessView(JoinChatRoomOutputData joinChatRoomOutputData,
                                   LogOutDataAccessBoundary logOutDataAccessBoundary,
                                   SendMessageUserDataAccessInterface sendMessageUserDataAccessInterface,
                                   RefreshMessagesDataAccessBoundary refreshMessagesDataAccessBoundary) throws IOException {
        ChatRoomState chatRoomState = new ChatRoomState();
        ChatRoomViewModel chatRoomViewModel = new ChatRoomViewModel();
        User user = joinChatRoomOutputData.getUser();
        List<String> messages = joinChatRoomOutputData.getMessages();
        String username = user.getUsername();
        chatRoomState.setUsername(username);
        chatRoomState.setSenderId(user.getUserid());
        chatRoomState.setMessage(messages);
        chatRoomViewModel.setChatRoomIdLabel(joinChatRoomOutputData.getChatRoomId());
        chatRoomViewModel.setUserNameLabel(username);
        chatRoomViewModel.setState(chatRoomState);
        chatRoomViewModel.firePropertyChanged();
        createChatRoomFrame(chatRoomViewModel, logOutDataAccessBoundary, sendMessageUserDataAccessInterface, refreshMessagesDataAccessBoundary);
    }

    @Override
    public void prepareFailView(JoinChatRoomOutputData joinChatRoomOutputData) {
    }

    @Override
    public void prepareSuccessView(LogOutOutputData logOutOutputData) {

    }

    @Override
    public void prepareFailView(LogOutOutputData logOutOutputData) {
    }
}
