Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

  resources :calendars, only: [:index, :show, :create, :update]
  resources :holiday_rules, path: 'calendars/:id/holiday_rules', only: [:index]

  #Example: get 'Route', to: 'ControllerName#ControllerAction'
  #get '/calendarios', to: 'calendars#calendars'
  #get '/calendarios/:name', to: 'calendars#index'
  #get '/calendarios/:id', to: 'calendars#show'
end
