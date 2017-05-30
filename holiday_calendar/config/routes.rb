Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

  resources :calendars, only: [:index, :show, :create, :update]
  resources :holiday_rules, path: 'calendars/:id/holiday_rules', only: [:index, :add_rule]
end
