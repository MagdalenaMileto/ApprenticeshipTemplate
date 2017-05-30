Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

  resources :calendars, only: [:index, :show, :create, :update]
  get 'calendars/:id/holiday_rules', to: 'calendars#get_holidays'
  put 'calendars/:id/holiday_rules', to: 'calendars#add_new_holiday'
end
